/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

/**
 *
 * @author david
 */
public class Libro extends Publicacion {
    private String autor;
    private String editorial;
    private int ano;

    public Libro(String nombre, String autor, String editorial, int ano) {
        super(nombre);
        this.autor = autor;
        this.editorial = editorial;
        this.ano = ano;
    }
public String getAutor() { return autor; }
    public String getEditorial() { return editorial; }
    public int getAno() { return ano; }
}