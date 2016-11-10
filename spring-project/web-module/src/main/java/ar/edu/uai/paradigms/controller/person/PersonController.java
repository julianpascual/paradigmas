package ar.edu.uai.paradigms.controller.person;

import ar.edu.uai.model.person.Person;
import ar.edu.uai.paradigms.dto.person.PersonCriteriaDTO;
import ar.edu.uai.paradigms.dto.person.PersonDTO;
import ar.edu.uai.paradigms.service.PersonService;
import ar.edu.uai.paradigms.translator.person.PersonTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Federico Donnarumma on 10/15/14.
 */

@Controller
@RequestMapping("/persons")
public class PersonController {

    public PersonController(
            PersonService personService,
            PersonTranslator personTranslator) {
        super();
        this.personService = personService;
        this.personTranslator = personTranslator;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PersonController.class);

    private PersonService personService;

    private PersonTranslator personTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        LOGGER.debug("Received DTO: " + personDTO);
        return new ResponseEntity<PersonDTO>(this.personTranslator.translateToDTO(this.personService
                .savePerson(this.personTranslator.translate(personDTO))), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<PersonDTO>> retrieveByCriteria(PersonCriteriaDTO personCriteria) {
        LOGGER.debug("Received QUERY: " + personCriteria);
        return new ResponseEntity<List<PersonDTO>>(this.personTranslator.translateToDTO(this.personService
                .retrieveByCriteria(this.personTranslator.translateCriteria(personCriteria))), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<PersonDTO> getPerson(@PathVariable Integer identifier) throws InterruptedException {
        PersonDTO person = this.personTranslator.translateToDTO(this.personService.retrievePerson(identifier));
        if (person != null) {
            return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
        }
        return new ResponseEntity<PersonDTO>(HttpStatus.NO_CONTENT);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}/getSons")
//    public
//    @ResponseBody
//    ResponseEntity<List<PersonDTO>> getSons(@PathVariable Integer identifier) throws InterruptedException {
//        List<PersonDTO> hijos = this.personTranslator.translateToDTO(this.personService.getSons(identifier));
//        return new ResponseEntity<List<PersonDTO>>(hijos, HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> deletePerson(@PathVariable Integer identifier) {
        this.personService.deletePerson(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{identifier}", consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<PersonDTO>addSon(@PathVariable Integer identifier, @RequestBody PersonDTO personDTO){
        Person son = this.personTranslator.translate(personDTO);
        if (this.personService.retrievePerson(identifier)!=null & son!=null){
            return new ResponseEntity<PersonDTO>(this.personTranslator.
                    translateToDTO(this.personService.addSon(identifier, son)), HttpStatus.OK);
        }else{
            return new ResponseEntity<PersonDTO>(HttpStatus.NO_CONTENT);
        }
    }
}