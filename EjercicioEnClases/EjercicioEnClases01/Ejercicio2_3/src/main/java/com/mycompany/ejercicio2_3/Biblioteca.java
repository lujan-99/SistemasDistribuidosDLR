package com.mycompany.ejercicio2_3;
import java.util.ArrayList;

class Biblioteca {
    String nombre;
    double m2;
    ArrayList<Armario> armarios = new ArrayList<>();

    Biblioteca(String n, double m) { 
        this.nombre = n; 
        this.m2 = m; 
    }

    void agregarArmario(Armario a) { armarios.add(a); }

    void listarTodo() {
        System.out.println("\n--- BIBLIOTECA: " + nombre + " (" + m2 + " m2) ---");
        for (Armario a : armarios) a.listar();
    }
}