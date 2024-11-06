package com.mycompany.tiendaonline;
import java.util.List;
import java.util.ArrayList;
public class Usuario {
    private int contador;
    private String nombre;
    private String apellido;
    private String id;
    private String telefono;
    private String direccion;
    private String contrasena;
    private double saldo;
    private Carrito_compras carrito;
    private String correo;
    private Formas_de_pago forma_de_pago;
    private List<Factura> historial_compras;
    private Factura histco;

    public void Crear_Usuario(String nombre, String apellido, String id, String telefono, String direccion, String contrasena, String correo){
        this.contador = contador;
        this.historial_compras = new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.correo = correo;
        this.carrito = new Carrito_compras();
        this.forma_de_pago = new Formas_de_pago();
    }
    
    public Usuario(){
        this.historial_compras = new ArrayList<>();
        this.contador = 0;
        this.nombre = null;
        this.apellido = null;
        this.id = null;
        this.telefono = null;
        this.direccion = null;
        this.contrasena = null;
        this.correo = null;
        this.carrito = new Carrito_compras();
        this.forma_de_pago = new Formas_de_pago();
    }

    public List<Factura> gethistorial_compras(){
        return historial_compras;
    }
    
    public void mostrarhistorial(){
        for(Factura fact: historial_compras){
            fact.generar();
        }
}
    
    public Factura gethistco(){
        return histco;
    }
    
    public int getcontador(){
        return contador;
    }
    
    public void setcontador(int contador){
        this.contador = contador;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getid(){
        return id;
    }

    public void setid(String id){
        this.id = id;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getContrasena(){
        return contrasena;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public Carrito_compras getCarrito_compras(){
        return carrito;
    }
    
    public Formas_de_pago getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(Formas_de_pago forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }
    
    

    public void editar_perfil(String nuevoNombre, String nuevoApellido, String nuevoTelefono, String nuevaDireccion) {
        this.nombre = nuevoNombre;
        this.apellido = nuevoApellido;
        this.telefono = nuevoTelefono;
        this.direccion = nuevaDireccion;
    }
    

    public void Mostrar_perfil(){
        System.out.println("NOMBRE: " + nombre);
        System.out.println("APELLIDO: " + apellido);
        System.out.println("CEDULA: " + id);
        System.out.println("TELEFONO: " + telefono);
        System.out.println("DIRECCION: " + direccion);
        System.out.println("CORREO: " + correo);
    }
    public void editar_contrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }

    
}