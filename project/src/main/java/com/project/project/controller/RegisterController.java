package com.project.project.controller;

import com.project.project.model.Resumen;
import com.project.project.service.services.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-data")
public class RegisterController {
    @Autowired
    private ResumenService resumenService;

    @GetMapping("/{id}/records")
    public List<Resumen> obtenerResumenes() {
        return resumenService.findAll();
    }

}
