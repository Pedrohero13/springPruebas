/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class Producto {
    private int codigoBarras;
    private String nombre;
    private String marca;
    private int stock;
    private double precioCompra;
    private double precioVenta;
    private String fechaVencimiento;
}
