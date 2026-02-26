package com.mycompany.ejercicio2_3;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblo = new Biblioteca("Biblioteca Ingenieria", 150.0);
        int opt;

        do {
            System.out.println("\n1. Crear Armario");
            System.out.println("2. Cargar Publicacion");
            System.out.println("3. Listar Biblioteca");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            opt = sc.nextInt();
            sc.nextLine(); 

            switch(opt) {
                case 1:
                    System.out.print("Codigo del nuevo armario: "); 
                    String c = sc.nextLine(); 
                    System.out.print("Material (1.Madera, 2.Metalico): ");
                    int mInt = sc.nextInt();
                    sc.nextLine(); 
                    Material m = (mInt == 1) ? Material.MADERA : Material.METALICO;
                    biblo.agregarArmario(new Armario(c, m));
                    System.out.println("Armario creado correctamente.");
                    break;

                case 2:
                    if(biblo.armarios.isEmpty()) {
                        System.out.println("Error: No hay armarios. Cree uno primero.");
                        break;
                    }
                    
                    System.out.print("Ingrese el codigo del armario donde desea guardar: ");
                    String codBusqueda = sc.nextLine();
                    Armario estanteElegido = null;
                    
                    for (Armario a : biblo.armarios) {
                        if (a.codigo.equalsIgnoreCase(codBusqueda)) {
                            estanteElegido = a;
                            break;
                        }
                    }

                    if (estanteElegido == null) {
                        System.out.println("Error: Armario no encontrado.");
                        break;
                    }

                    System.out.print("Tipo (1.Libro, 2.Revista, 3.Periodico): ");
                    int tipo = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Nombre o Titulo: ");
                    String nom = sc.nextLine(); 

                    if(tipo == 1) {
                        System.out.print("Autor: "); String aut = sc.nextLine();
                        System.out.print("Editorial: "); String edit = sc.nextLine();
                        System.out.print("Año: "); int anio = sc.nextInt();
                        sc.nextLine();
                        estanteElegido.agregar(new Libro(nom, aut, edit, anio));
                    } else if(tipo == 2) {
                        System.out.print("Mes: "); String mes = sc.nextLine();
                        System.out.print("Año: "); int anioR = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Tipo (1.Tecnica, 2.Moda, 3.Variedades): ");
                        int tRev = sc.nextInt(); sc.nextLine();
                        TipoRevista tr = TipoRevista.TECNICA;
                        if(tRev == 2) tr = TipoRevista.MODA;
                        if(tRev == 3) tr = TipoRevista.VARIEDADES;
                        estanteElegido.agregar(new Revista(nom, mes, anioR, tr));
                    } else if(tipo == 3) {
                        System.out.print("Fecha: "); String fec = sc.nextLine();
                        ArrayList<String> sup = new ArrayList<>();
                        sup.add("Suplemento General");
                        estanteElegido.agregar(new Periodico(nom, fec, sup));
                    }
                    System.out.println("Publicacion cargada con exito en el armario: " + codBusqueda);
                    break;

                case 3:
                    biblo.listarTodo();
                    break;
                
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while(opt != 4);
        sc.close();
    }
}