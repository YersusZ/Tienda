
package com.mycompany.tiendaonline;

public class Articulo {
    private int id;
    private String nombre;
    private int precio;
    private String clasificacion;
    private int cantidad;
    // Otros atributos según tus necesidades
    
    // Constructor

    public void Crear_Articulo(int id, String nombre, int precio, String clasificacion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.clasificacion = clasificacion;
        this.cantidad = cantidad;
    }
    
    public Articulo() {
        this.id = 0;
        this.nombre = null;
        this.precio = 0;
        this.clasificacion = null;
        this.cantidad = 0;
    }
    
    // Getters y setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPrecio() {
        return precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void MostrarArticulo(){
        System.out.println(nombre + " | Precio: $" + precio + " | Clasificación: " + clasificacion + " | Cantidad en stock: " + cantidad + "\n");
    }
}