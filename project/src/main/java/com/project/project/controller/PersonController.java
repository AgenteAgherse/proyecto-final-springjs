package com.project.project.controller;

import com.project.project.model.Person;
import com.project.project.service.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-data")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonInfo(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Person Person) {
        personService.addUpdate(Person);
    }

    @PutMapping("/actualizar")
    public void update(@RequestBody Person Person) {
        if (personService.findById(Person.getId()) == null) return;
        personService.addUpdate(Person);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        personService.deleteById(id);
    }

}
