package ar.edu.uai.model.person;


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

//    @OneToMany
//    @JoinColumn(name="FATHER")
//    List<Person> sons = new ArrayList<Person>();

//    public Person() {
//    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(Integer id, String name, Integer age, Person father) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.father = father;
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

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

//    public void setSons(List<Person> sons) {
//        this.sons = sons;
//    }
//
//    public void addSon(Person son){
//        sons.add(son);
//    }
}
