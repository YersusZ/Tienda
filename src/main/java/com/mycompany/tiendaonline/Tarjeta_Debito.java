/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tiendaonline;

/**
 *
 * @author yalit
 */
public class Tarjeta_Debito{
    private String numero;
    private String fecha_vencimiento;
    private String CCV;
    private double saldo;

    public Tarjeta_Debito() {
        this.numero = null;
        this.fecha_vencimiento = null;
        this.CCV = null;
        this.saldo = 0;
    }

    public String getNumero() {
        return numero;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public String getCCV() {
        return CCV;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}