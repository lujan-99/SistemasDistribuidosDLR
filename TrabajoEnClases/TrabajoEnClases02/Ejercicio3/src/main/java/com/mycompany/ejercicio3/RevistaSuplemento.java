/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author david
 */
public class RevistaSuplemento extends Suplemento {

    public RevistaSuplemento(String nombreSuplemento) {
        super(nombreSuplemento);
    }

    @Override
    public String obtenerIdentificador() {
        return "Revista (Suplemento): " + nombreSuplemento;
    }
}