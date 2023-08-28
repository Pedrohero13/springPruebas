/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
public class Controller {
    @Autowired
    IndicadoresService indicadoresService;
    
    @GetMapping("/contar-indicadores")
    public Map<String, Object> getNumeroregistros() {
        return indicadoresService.obtenerNumeroRegistros();
    }
    
    @PostMapping("/filtrar-lista")
    public Map<String, Object> getListaFiltrada(@Validated @RequestBody FechaRespuesta fechaRespuesta){
        return indicadoresService.filtrarPorFecha(fechaRespuesta);
    }
    
    
}
