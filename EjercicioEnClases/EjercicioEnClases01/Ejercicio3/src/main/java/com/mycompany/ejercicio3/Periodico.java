/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio3;

import java.util.ArrayList;

/**
 * @author david
 */
public class Periodico extends Publicacion {
    private String fecha;
    private ArrayList<Suplemento> suplementos;

    public Periodico(String nombre, String fecha) {
        super(nombre);
        this.fecha = fecha;
        this.suplementos = new ArrayList<>();
    }

    // --- MÉTODOS DE COMPORTAMIENTO ---

    /**
     * Agrega un objeto que implemente la interfaz Suplemento.
     */
    public void agregarSuplemento(Suplemento s) {
        if (s != null) {
            this.suplementos.add(s);
        }
    }

    /**
     * Devuelve una cadena con los nombres de todos los suplementos.
     * Útil para el reporte final.
     */
    public String listarSuplementos() {
        if (suplementos.isEmpty()) {
            return "Sin suplementos";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Suplemento s : suplementos) {
            sb.append("[").append(s.obtenerIdentificador()).append("] ");
        }
        return sb.toString();
    }

    // --- GETTERS Y SETTERS ---

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Suplemento> getSuplementos() {
        return suplementos;
    }

    public void setSuplementos(ArrayList<Suplemento> suplementos) {
        this.suplementos = suplementos;
    }
}