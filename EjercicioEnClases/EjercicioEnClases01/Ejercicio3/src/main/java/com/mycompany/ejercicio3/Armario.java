package com.mycompany.ejercicio3;

import java.util.ArrayList;

/**
 * @author david
 */
public class Armario {
    private String codigo;
    private Material material;
    private ArrayList<Publicacion> publicaciones;

    public Armario(String codigo, Material material) {
        this.codigo = codigo;
        this.material = material;
        this.publicaciones = new ArrayList<>();
    }

    // --- MÉTODOS DE COMPORTAMIENTO ---

    /**
     * Agrega una publicación al armario.
     * Gracias al polimorfismo, puede recibir Libro, Revista o Periodico.
     */
    public void agregarPublicacion(Publicacion p) {
        if (p != null) {
            this.publicaciones.add(p);
            System.out.println("Sucesos: " + p.getClass().getSimpleName() + " añadido al armario " + codigo);
        }
    }

    /**
     * Retorna la cantidad de publicaciones actuales.
     */
    public int obtenerCantidadPublicaciones() {
        return this.publicaciones.size();
    }

    /**
     * Muestra el detalle de lo que hay dentro de este armario específico.
     */
    public void mostrarDetalleArmario() {
        System.out.println("Armario Cod: " + codigo + " | Material: " + material);
        if (publicaciones.isEmpty()) {
            System.out.println("   (Este armario está vacío)");
        } else {
            for (Publicacion p : publicaciones) {
                // Imprime el nombre y el tipo de clase (Libro, Revista, etc.)
                System.out.println("   - [" + p.getClass().getSimpleName() + "] Nombre: " + p.nombre);
            }
        }
    }

    // --- GETTERS Y SETTERS ---

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Material getMaterial() { return material; }
    public void setMaterial(Material material) { this.material = material; }

    public ArrayList<Publicacion> getPublicaciones() { return publicaciones; }
    public void setPublicaciones(ArrayList<Publicacion> publicaciones) { this.publicaciones = publicaciones; }
}