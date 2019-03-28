package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
//    @Autowired
//    private PersonService personService;
//

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<Person>(personService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@PathVariable Person p){
        return new ResponseEntity<Person>(personService.create(p), HttpStatus.CREATED);
    }

    @GetMapping("/people")
    public List<Person> getPersonList(){
        return new ResponseEntity<Person>(personService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> update(@PathVariable Person p, int id){
        return new ResponseEntity<Person>(personService.update(id,p), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Person> delete(@PathVariable int id){
        return new ResponseEntity<Person>(personService.delete(id),HttpStatus.OK);
    }

}
