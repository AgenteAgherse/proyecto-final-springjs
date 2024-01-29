package com.project.project.controller;

import com.project.project.model.User;
import com.project.project.service.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping
    public List<User> obtenerUsuarios() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        if (userService.findById(user.getUser_id()) != null) return;

        userService.addUpdate(user);
    }

    @PutMapping("/actualizar")
    public void update(@RequestBody User user) {
        if (userService.findById(user.getUser_id()) == null) return;
        userService.addUpdate(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }


}
