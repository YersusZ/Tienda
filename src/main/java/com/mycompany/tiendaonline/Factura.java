/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

/**
 *
 * @author yalit
 */

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private String Id_factura;
    private Carrito_compras larticulos;
    private String fecha;
    private double Total_pagado;
    private String Forma_de_pago;
    private String Destino;
    private String Fecha_aproximada_entrega;
    // Parametros

    // Constructor
    public Factura(String Id_factura, Carrito_compras larticulos, String fecha, double Total_pagado, String Forma_de_pago, String Destino) {
        this.Id_factura = Id_factura;
        this.larticulos = larticulos;
        this.fecha = fecha;
        this.Total_pagado = Total_pagado;
        this.Forma_de_pago = Forma_de_pago;
        this.Destino = Destino;
        this.Fecha_aproximada_entrega = Fecha_aproximada_entrega;
    }

    // Getters y setters
    
    public String getId_factura() {
        return Id_factura;
    }

    public Carrito_compras getlarticulos() {
        return larticulos;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotal_pagado() {
        return Total_pagado;
    }

    public String getForma_de_pago() {
        return Forma_de_pago;
    }  

    public String getDestino() {
        return Destino;
    }

    public String getFecha_aproximada_entrega() {
        return Fecha_aproximada_entrega;
    }

    public void setId_factura(String Id_factura) {
        this.Id_factura = Id_factura;
    }

    public void setLista_articulos(Articulo Lista_articulos) {
        this.larticulos = larticulos;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal_pagado(int Total_pagado) {
        this.Total_pagado = Total_pagado;
    }

    public void setForma_de_pago(String Forma_de_pago) {
        this.Forma_de_pago = Forma_de_pago;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public void setFecha_aproximada_entrega(String Fecha_aproximada_entrega) {
        this.Fecha_aproximada_entrega = Fecha_aproximada_entrega;
    }
    
    // Metodo para generar la factura.
    public void generar(){
        System.out.println("Id factura: " + Id_factura + "\nLista Articulos: " + larticulos + "\nFecha: " + fecha + "\nTotal pagado: " + Total_pagado + "\nForma de pago: " + Forma_de_pago +"\nDestino: " + Destino); 
    }
}