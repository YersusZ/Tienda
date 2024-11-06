/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

/**
 *
 * @author yalit
 */
public class Banco{
    private String numero_root;
    private String numero_cuenta_corriente;
    private double saldo;

    public Banco() {
        this.numero_root = null;
        this.numero_cuenta_corriente = null;
        this.saldo = 0;
    }

    public String getNumero_root() {
        return numero_root;
    }

    public String getNumero_cuenta_corriente() {
        return numero_cuenta_corriente;
    }

    public void setNumero_root(String numero_root) {
        this.numero_root = numero_root;
    }

    public void setNumero_cuenta_corriente(String numero_cuenta_corriente) {
        this.numero_cuenta_corriente = numero_cuenta_corriente;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
