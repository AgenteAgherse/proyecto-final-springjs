package com.project.project.controller;

import com.project.project.model.Person;
import com.project.project.service.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-data")
@CrossOrigin("*")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonInfo(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Person person) {
        person.setIdentification(person.getIdentification());
        personService.addUpdate(person);
    }

    @PutMapping("/actualizar")
    public void update(@RequestBody Person Person) {
        if (personService.findById(Person.getIdentification()) == null) return;
        personService.addUpdate(Person);
    }

}
