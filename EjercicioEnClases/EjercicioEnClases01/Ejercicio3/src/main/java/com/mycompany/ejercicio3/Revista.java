/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author david
 */
public class Revista extends Publicacion {
    private String mes;
    private int ano;
    private Tipo tipo;

    public Revista(String nombre, String mes, int ano, Tipo tipo) {
        super(nombre);
        this.mes = mes;
        this.ano = ano;
        this.tipo = tipo;
    }
}