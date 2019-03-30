package io.zipcoder.crudapp;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){


        return new ResponseEntity<Person>(personRepository.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<Person>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people")
    public ResponseEntity<Person> getPersonList(){

        return new ResponseEntity<Person>((Person) personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> update(@RequestBody Person p){

        Long id = p.getId();

        Person original = personRepository.findOne(id);

        original.setFirstName(p.getFirstName());
        original.setLastName(p.getLastName());

        return new ResponseEntity<Person>(personRepository.save(original), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        personRepository.delete(id);
        return new ResponseEntity<Boolean>(true,HttpStatus.NO_CONTENT);
    }

}
