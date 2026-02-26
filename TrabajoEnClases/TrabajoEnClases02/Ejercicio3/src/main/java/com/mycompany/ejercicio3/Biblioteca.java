package com.mycompany.ejercicio3;

import java.util.ArrayList;

/**
 * @author david
 */
public class Biblioteca {
    private String nombre;
    private double tamanoM2; // Tamaño en metros cuadrados
    private ArrayList<Armario> armarios; // Array de objetos Armario

    public Biblioteca(String nombre, double tamanoM2) {
        this.nombre = nombre;
        this.tamanoM2 = tamanoM2;
        this.armarios = new ArrayList<>();
    }

    // --- MÉTODOS DE COMPORTAMIENTO ---

    /**
     * Agrega un armario a la lista de la biblioteca.
     */
    public void agregarArmario(Armario armario) {
        if (armario != null) {
            this.armarios.add(armario);
        }
    }

    /**
     * Muestra toda la estructura de la biblioteca: sus armarios 
     * y las publicaciones dentro de cada uno.
     */
    public void listarBiblioteca() {
        System.out.println("========== REPORTE DE BIBLIOTECA ==========");
        System.out.println("Nombre: " + nombre);
        System.out.println("Superficie: " + tamanoM2 + " m2");
        System.out.println("Total de Armarios: " + armarios.size());
        System.out.println("-------------------------------------------");

        if (armarios.isEmpty()) {
            System.out.println("La biblioteca aún no tiene armarios registrados.");
        } else {
            for (int i = 0; i < armarios.size(); i++) {
                System.out.print("ID [" + i + "] "); // Mostramos el índice para facilitar la carga
                armarios.get(i).mostrarDetalleArmario();
                System.out.println("-------------------------------------------");
            }
        }
    }

    // --- GETTERS Y SETTERS ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTamanoM2() {
        return tamanoM2;
    }

    public void setTamanoM2(double tamanoM2) {
        this.tamanoM2 = tamanoM2;
    }

    public ArrayList<Armario> getArmarios() {
        return armarios;
    }

    public void setArmarios(ArrayList<Armario> armarios) {
        this.armarios = armarios;
    }
}