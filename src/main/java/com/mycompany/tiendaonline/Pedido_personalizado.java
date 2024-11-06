/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

/**
 *
 * @author jhons
 */
public class Pedido_personalizado {
    private String tipo;
    private String tematica;
    private String eleccion;
    private int precio;
    private int cantidad;

    public Pedido_personalizado(String tipo, String tematica, String eleccion, int cantidad) {
        this.tipo = tipo;
        this.tematica = tematica;
        this.eleccion = eleccion;
        this.precio = calcularPrecio(tipo, tematica);
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTematica() {
        return tematica;
    }
    
    public String getEleccion(){
        return eleccion;
    }

    public int getPrecio() {
        return precio;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    private int calcularPrecio(String tipo, String tematica) {
        int precioBase;
        if (tipo.equalsIgnoreCase("Tazas") || tipo.equalsIgnoreCase("Tarros para agua")) {
            precioBase = 10000;
        } else {
            precioBase = 5000;
        }

        if (tematica.equalsIgnoreCase("Anime")) {
            precioBase += 500;
        } else if (tematica.equalsIgnoreCase("Peliculas")) {
            precioBase += 400;
        }

        return precioBase;
    }
}