/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


/**
 *
 * @author USER
 */
@Service
public class IndicadoresService {

    @Value("${spring.datasource.url}")
    private String url;

    public Map<String, Object> filtrarPorFecha(FechaRespuesta fechaPeticion) {

        List<Indicadores> indicadores = this.obtenerLista();
        List<Indicadores> listaFiltrada = new ArrayList<>();

        for (int i = 0; i < indicadores.size(); i++) {
            Indicadores indicador = indicadores.get(i);
            LocalDateTime fecha = indicador.getFecha();
            if (fecha.equals(fechaPeticion.getFechaInicio()) || fecha.isAfter(fechaPeticion.getFechaInicio()) && fecha.isBefore(fechaPeticion.getFechaFin())) {
                listaFiltrada.add(indicador);
            }
            if(fecha.equals(fechaPeticion.getFechaFin())){
                listaFiltrada.add(indicador);
                i = indicadores.size();
            }

        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Lista_filtrada", listaFiltrada);
        return respuesta;

    }

    public Map<String, Object> obtenerNumeroRegistros() {
        Map<String, Object> respuesta = new HashMap<>();

        List<Indicadores> indicadores = this.obtenerLista();
        if (indicadores != null) {
            respuesta.put(Constantes.NUMERO_REGISTROS, indicadores.size());
        } else {
            respuesta.put("Error", "No hay registros");
        }
        return respuesta;

    }

    public List<Indicadores> obtenerLista() {
        try {
            //        WebClient client = WebClient.create();
//
//        return client
//        .get()
//        .uri(url)
//        .retrieve()
//        .bodyToFlux(Indicadores.class)
//        .collectList()
//        .block();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
// Supongamos que tienes un archivo JSON llamado "personas.json" en la raíz del classpath
            ClassPathResource resource = new ClassPathResource("/data.json");

            List<Indicadores> personas = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Indicadores>>() {
            });

            return personas;
        } catch (IOException ex) {
            
            Logger.getLogger(IndicadoresService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
