
package com.keyin.demo.restservice;

import java.util.ArrayList;
import java.util.List;

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
/*
    @GetMapping("/person/{Id}")
    public ResponseEntity getCurrentTournamentsById(@PathVariable("Id") int Id) {
        Optional<Person> person = PersonRepository.findById(Id);

        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person _person = PersonRepository
                    .save(new Person(person.getId(),
                           person.getFirstName(), false));
            return new ResponseEntity<>(_person, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/person/{Id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("Id") int Id, @RequestBody Person person) {
        Optional<Person> Person = PersonRepository.findById(Id);

        if (person.isPresent()) {
           Person _person = person.get();
            _person.setId(person.getId());
            _person.setId(person.getId());
            _person.setPublished(person.isPublished());
            return new ResponseEntity<>(PersonRepository.save(_person), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/person/{Id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable("Id") int Id) {
        try {
            PersonRepository.deleteById(Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
