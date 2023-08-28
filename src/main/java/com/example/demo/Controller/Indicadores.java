/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class Indicadores {
    
    private Long folio;
    private Double subida;
    private Double bajada;
    private Double ping;
    private String host;
    private String isp;
    private LocalDate fecha;
    private String comentario;
}
