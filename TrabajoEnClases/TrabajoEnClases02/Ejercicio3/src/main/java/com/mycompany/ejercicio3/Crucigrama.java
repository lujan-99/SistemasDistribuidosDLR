/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author david
 */


public class Crucigrama extends Suplemento {
    
    public Crucigrama(String nombre) {
        super(nombre);
    }

    @Override
    public String obtenerIdentificador() {
        return "Crucigrama: " + nombreSuplemento;
    }
}