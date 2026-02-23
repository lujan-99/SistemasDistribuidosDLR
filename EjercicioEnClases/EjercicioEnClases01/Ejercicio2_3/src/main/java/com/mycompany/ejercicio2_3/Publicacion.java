package com.mycompany.ejercicio2_3;
import java.util.ArrayList;

abstract class Publicacion {
    String nombre;
    Publicacion(String n) { this.nombre = n; }
    abstract void mostrar();
}

class Libro extends Publicacion {
    String autor, editorial;
    int anio;
    Libro(String n, String a, String e, int an) {
        super(n); this.autor = a; this.editorial = e; this.anio = an;
    }
    @Override
    void mostrar() { System.out.println("Libro: " + nombre + " | Autor: " + autor + " | Año: " + anio); }
}

class Revista extends Publicacion {
    String mes;
    int anio;
    TipoRevista tipo;
    Revista(String n, String m, int a, TipoRevista t) {
        super(n); this.mes = m; this.anio = a; this.tipo = t;
    }
    @Override
    void mostrar() { System.out.println("Revista: " + nombre + " | Mes: " + mes + " | Tipo: " + tipo); }
}

class Periodico extends Publicacion {
    String fecha;
    ArrayList<String> suplementos;
    Periodico(String n, String f, ArrayList<String> s) {
        super(n); this.fecha = f; this.suplementos = s;
    }
    @Override
    void mostrar() { System.out.println("Periodico: " + nombre + " | Fecha: " + fecha + " | Suplementos: " + suplementos); }
}