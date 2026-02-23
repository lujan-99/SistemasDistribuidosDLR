package com.mycompany.ejercicio2_3;
import java.util.ArrayList;

class Armario {
    String codigo;
    Material material;
    ArrayList<Publicacion> lista = new ArrayList<>();

    Armario(String c, Material m) { 
        this.codigo = c; 
        this.material = m; 
    }

    void agregar(Publicacion p) { lista.add(p); }

    void listar() {
        System.out.println("Armario: " + codigo + " [" + material + "]");
        for (Publicacion p : lista) p.mostrar();
    }
}