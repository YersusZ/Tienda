/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

/**
 *
 * @author yalit
 */
public class Formas_de_pago {
    private String nombre;
    private Paypal paypal;
    private Tarjeta_Credito credito;
    private Tarjeta_Debito debito;
    private Banco banco;

    public Formas_de_pago(){
        this.nombre = null;
        this.paypal = new Paypal();
        this.credito = new Tarjeta_Credito();
        this.debito = new Tarjeta_Debito();
        this.banco = new Banco();
    }
    
    public String getNombre() {
        return nombre;
    }

    public Paypal getPaypal() {
        return paypal;
    }

    public Tarjeta_Credito getCredito() {
        return credito;
    }

    public Tarjeta_Debito getDebito() {
        return debito;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    public void setCredito(Tarjeta_Credito credito) {
        this.credito = credito;
    }

    public void setDebito(Tarjeta_Debito debito) {
        this.debito = debito;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public boolean PaypalExiste(){
        return (paypal.getCorreo() != null);
    }
    
    public boolean CreditoExiste(){
        return (credito.getNumero() != null);
    }
    
    public boolean DebitoExiste(){
        return (debito.getNumero()!= null);
    }
    
    public boolean BancoExiste(){
        return (banco.getNumero_cuenta_corriente() != null);
    }
    
    public void mostrarPaypal(){
        System.out.println("Paypal: " + paypal.getCorreo());
    }
    
    public void mostrarCredito(){
        System.out.println("Número: " + credito.getNumero() + " | Fecha de vencimiento: " + credito.getFecha_vencimiento());
    }
    
    public void mostrarDebito(){
        System.out.println("Número: " + debito.getNumero() + " | Fecha de vencimiento: " + debito.getFecha_vencimiento());
    }
    
    public void mostrarBanco(){
        System.out.println("Número root: " + banco.getNumero_root() + " | Cuenta corriente: " + banco.getNumero_cuenta_corriente());
    }
    
    public void mostrar_Formas(){
        if (PaypalExiste()){
            mostrarPaypal();
        }
        else{
            System.out.print("No tienes un Paypal asociado. | ");
        }
        if (CreditoExiste()){
            mostrarCredito();
        }
        else{
            System.out.print("No tienes una Tarjeta de Crédito asociada. | ");
        }
        if (DebitoExiste()){
            mostrarDebito();
        }
        else{
            System.out.print("No tienes una Tarjeta de Débito asociada. | ");
        }
        if (BancoExiste()){
            mostrarBanco();
        }
        else{
            System.out.print("No tienes una cuenta bancaria asociada.\n");
        }
    }
}
