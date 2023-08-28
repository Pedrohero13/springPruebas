/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.time.LocalDate;
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
        
        List<Indicadores> indicadores = this.obtenerLista();
        List <Indicadores> listaFiltrada = new ArrayList<>();
        
        for (int i = 0; i< indicadores.size(); i++) {
            Indicadores indicador = indicadores.get(i);
            LocalDate fecha = indicador.getFecha();
            if (fecha.equals(fechaRespuesta.getFechaInicio()) || fecha.isAfter(fechaRespuesta.getFechaInicio()) && fecha.isBefore(fechaRespuesta.getFechaFin().plusDays(1))) {
                listaFiltrada.add(indicador);
            }
            
        }
        
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Lista_filtrada", listaFiltrada);
        return respuesta;
        
    }
    public Map<String, Object> obtenerNumeroRegistros() {
        Map<String, Object> respuesta = new HashMap<>();
        
        List<Indicadores> indicadores = this.obtenerLista();
        if(indicadores!=null){
            respuesta.put("Numero_de_registros", indicadores.size());
        }else{
            respuesta.put("Error", "No hay registros");
        }
        return respuesta;
    
      }
    
    public List<Indicadores> obtenerLista(){
        WebClient client = WebClient.create();

        return client
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(Indicadores.class)
        .collectList()
        .block();
    }
    
   
}