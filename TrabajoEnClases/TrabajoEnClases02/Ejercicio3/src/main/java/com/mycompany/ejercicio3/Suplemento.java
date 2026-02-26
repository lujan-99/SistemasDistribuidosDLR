/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author david
 */
public abstract class Suplemento {
    protected String nombreSuplemento; // El dato que mencionaste

    public Suplemento(String nombreSuplemento) {
        this.nombreSuplemento = nombreSuplemento;
    }

    // Método abstracto que las hijas deben implementar
    public abstract String obtenerIdentificador();

    public String getNombreSuplemento() {
        return nombreSuplemento;
    }
}


