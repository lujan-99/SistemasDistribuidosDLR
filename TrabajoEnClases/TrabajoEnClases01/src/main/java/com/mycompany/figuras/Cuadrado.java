/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuras;

/**
 *
 * @author david
 */
public class Cuadrado implements IFigura {
    
    int lado;
    
    public Cuadrado(int lado){
        this.lado = lado;
    }

    @Override
    public int area() {
        return 4 * lado;
    }
}