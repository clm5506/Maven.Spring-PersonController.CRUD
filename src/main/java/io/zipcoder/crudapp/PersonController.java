package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class PersonController {
//    @Autowired
//    private PersonService service;
//

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return null;
    }


    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@PathVariable Person p){
        return null;
    }

    List<Person> getPersonList(){
            return null;
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> update(@PathVariable Person p){
        
    }

}
