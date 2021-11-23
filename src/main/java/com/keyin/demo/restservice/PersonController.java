
package com.keyin.demo.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.keyin.demo.Repository.PersonRepository;
import com.keyin.demo.accessdatarest.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPerson(@RequestParam(required = false) String lastName) {
        try {
            List<Person> person = new ArrayList<Person>();

            if (lastName == null)
                personRepository.findAll().forEach(person::add);
            else {
                personRepository.findByLastName(lastName).forEach(person::add);
            }

            if (person.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person _person = personRepository
                    .save(new Person(person.getFirstName(),
                           person.getLastName(), person.getEmailAddress(), person.getPhoneNumber(), person.getStartDate(), person.getEndDate()));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/person/{Id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("Id") long Id, @RequestBody Person person) {
        Optional<Person> personsData = personRepository.findById(Id);

        if (personsData.isPresent()) {
           Person _person = personsData.get();
            _person.setFirstName(person.getFirstName());
            _person.setLastName(person.getLastName());
            _person.setEmailAddress(person.getEmailAddress());
            _person.setPhoneNumber(person.getPhoneNumber());
            _person.setEndDate(person.getStartDate());
            _person.setEndDate(person.getEndDate());
            return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/person/{Id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("Id") long Id) {
        try {
            personRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/*
    @DeleteMapping("/person")
    public ResponseEntity<HttpStatus> deleteAllPerson() {
        try {
            PersonRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
 */
}
