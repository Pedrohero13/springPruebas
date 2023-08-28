/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
public class Controller {
    @Autowired
    IndicadoresService pruebVelocidadService;
    
    @GetMapping("/leer-indicadores")
    public Map<String, Object> getNumeroregistros() {
        return pruebVelocidadService.obtenerNumeroRegistros();
    }
    
    
}
