/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
public class Controller {
    @Autowired
    PruebVelocidadService pruebVelocidadService;
    
    @GetMapping("/productos")
    public List<PruebaVelocidadInternet> getUser() {
        return pruebVelocidadService.obtenerNumeroRegistros();
    }
}
