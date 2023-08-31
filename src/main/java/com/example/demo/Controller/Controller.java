/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@CrossOrigin(origins = "*")
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
     @GetMapping("/obtener-rango-horas")
    public Map<String,  Map<String, String>> getRangoHoras() {
        
        LocalDateTime horaActual = LocalDateTime.now(); 
        Map<String,  Map<String, String>> rangoHoras = new HashMap<>();
        Map<String, String> horaRestada =null;
        
        List<Long> horas  = new ArrayList<>();
        horas.add(1L);
        horas.add(48L);
        //agregar mas horas si se desea 
        
         for (Long hora : horas) {
             horaRestada = new HashMap<>();
             horaRestada.put("fechaactual",horaActual.toString());
             horaRestada.put("fechaM"+hora+"Hora",horaActual.minusHours(hora).toString());
             rangoHoras.put(hora.toString()+ ((hora==1)? "hora" : "horas") , horaRestada);
         }
        
        return rangoHoras;
    }
    
}
