/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author USER
 */
@Service
public class PruebVelocidadService {

    @Value("${spring.datasource.url}")
    private String url;

    

    public List<PruebaVelocidadInternet> obtenerNumeroRegistros() {
        WebClient client = WebClient.create();

        return client
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(PruebaVelocidadInternet.class)
        .collectList()
        .block();
    
      }
}