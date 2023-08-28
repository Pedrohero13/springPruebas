/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author USER
 */
@Service
public class IndicadoresService {

    @Value("${spring.datasource.url}")
    private String url;

    
    public Map<String, Object> filtrarPorFecha(FechaRespuesta fechaRespuesta){
        Map<String, Object> entrada = this.obtenerNumeroRegistros();
        
        List<Indicadores> indicadores = (List<Indicadores>) entrada.get("Lista");
        List <Indicadores> listaFiltrada = new ArrayList<>();
        
        for (Indicadores indicador : indicadores) {
            LocalDateTime fecha = indicador.getFecha();
            if (fecha.isAfter(fechaRespuesta.getFechaInicio()) && fecha.isBefore(fechaRespuesta.getFechaFin())) {
                listaFiltrada.add(indicador);
            }
        }
        
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Lista_filtrada", listaFiltrada);
        return respuesta;
        
    }
    public Map<String, Object> obtenerNumeroRegistros() {
        Map<String, Object> respuesta = new HashMap<>();
        WebClient client = WebClient.create();

        List<Indicadores> indicadores = client
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(Indicadores.class)
        .collectList()
        .block();
        
        if(indicadores!=null){
            respuesta.put("Numero_de_registros", indicadores.size());
            respuesta.put("Lista", indicadores);
        }else{
            respuesta.put("Error", "No hay registros");
        }
        return respuesta;
    
      }
    
   
}