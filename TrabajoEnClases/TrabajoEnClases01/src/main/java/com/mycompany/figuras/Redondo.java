/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.figuras;

/**
 *
 * @author david
 */
public class Redondo implements IFigura{
    
    int radio;

    public Redondo(int radio) {
        this.radio = radio;
    }
    
    
    
    @Override
    public int area() {
        double area = Math.PI * Math.pow(radio, 2);
        return (int) area; 
    }
}
