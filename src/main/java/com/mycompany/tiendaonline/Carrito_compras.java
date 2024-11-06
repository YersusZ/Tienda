/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

import java.util.ArrayList;
import java.util.List;

public class Carrito_compras {
    
    //Atributos
    private List<Articulo> articulos;
    private List<Pedido_personalizado> articulos_p;
    private double total;
    
    //Constructor
    public Carrito_compras (){
        articulos = new ArrayList<>();
        articulos_p = new ArrayList<>();
        total = 0;
    }
    
    //getters 
    
    public List<Articulo> getListaArticulos(){
        return articulos;
    }
    
    public List<Pedido_personalizado> getListaP(){
        return articulos_p;
    }
    
    //Metodos
     public void agregarProducto(Articulo articulo) {
        articulos.add(articulo);
    }
     
    public void agregarProductoPersonalizado(Pedido_personalizado pedidoPersonalizado) {
    articulos_p.add(pedidoPersonalizado);
    }

    public void eliminarProducto(Articulo articulo) {
        articulos.remove(articulo);
    }
    
    public void eliminarProductoPersonalizado(Pedido_personalizado pedidoPersonalizado) {
    articulos_p.remove(pedidoPersonalizado);
    }

    public double calcularTotal() {
        total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getPrecio()*articulo.getCantidad();
        }
        for (Pedido_personalizado pedp: articulos_p){
            total += pedp.getPrecio()*pedp.getCantidad();
        }
        return total;
    }
    public void Mostrar_articulos(){
        int i = 1;
        for (Articulo articulo: articulos){
            System.out.println(i + ". Articulo: " + articulo.getNombre() + " | Precio: " + articulo.getPrecio() + " | Cantidad: " + articulo.getCantidad() + " | Clasificacion: " + articulo.getClasificacion());
            i++;
        }
        for (Pedido_personalizado pedp: articulos_p){
            System.out.println(i + ".Pedido personalizado " + i + ": " +"|Tipo: " + pedp.getTipo() + " | Tematica: " + pedp.getTematica() + " | Eleccion: " + pedp.getEleccion() + " | Precio: " + pedp.getPrecio() + " | Cantidad: " + pedp.getCantidad());
            i++;
        }
    }
    public Articulo Buscar_articulo_por_nombre(String articulox){
        Articulo articulovacio = new Articulo();
        for (Articulo articulo: articulos){
            if (articulo.getNombre().equalsIgnoreCase(articulox)){
                return articulo;
            }
        }
        return articulovacio;
    }
}


