/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuras;

/**
 *
 * @author david
 */
public class Rectangulos implements IFigura {
    int alto;
    int ancho;

    public Rectangulos(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }
    
    @Override
    public int area() {
        return (alto + ancho) * 2;
    }
    
}
