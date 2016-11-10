package ar.edu.uai.model.person;


import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@Access(AccessType.FIELD)
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "PERSON_ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE", nullable = false)
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "FATHER")
    private Person father;

    @OneToMany
    @JoinColumn(name="FATHER")
    List<Person> sons = new ArrayList<Person>();

    public Person() {
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addSon(Person person)
    {
        if (person != null)
        {
            if (sons.contains(person) == false){
                this.sons.add(person);
                person.setFather(this);
            }
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }


}
