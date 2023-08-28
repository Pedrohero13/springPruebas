/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author USER
 */
@Service
public class IndicadoresService {

    @Value("${spring.datasource.url}")
    private String url;

    

    public Map<String, Object> obtenerNumeroRegistros() {
        Map<String, Object> respuesta = new HashMap<>();
        WebClient client = WebClient.create();

        List<Indicadores> productos = client
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(Indicadores.class)
        .collectList()
        .block();
        
        if(productos!=null){
            respuesta.put("Numero_de_registros", productos.size());
        }else{
            respuesta.put("Error", "No hay registros");
        }
        return respuesta;
    
      }
    
   
}