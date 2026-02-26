package com.mycompany.ejercicio3;

import java.sql.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio3 {

    // Variable global para mantener el ID de la biblioteca actual en la DB
    private static int idBibliotecaDB = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca miBiblioteca = null;

        System.out.println("=== CONFIGURACIÓN INICIAL DEL SISTEMA (MySQL) ===");
        try {
            System.out.print("Nombre de la Biblioteca: ");
            String nom = sc.nextLine();
            System.out.print("Tamaño (m2): ");
            double tam = sc.nextDouble();
            sc.nextLine(); 

            // --- INSERCIÓN EN BD: BIBLIOTECA ---
            try (Connection con = Conexion.getConexion()) {
                String sql = "INSERT INTO bibliotecas (nombre, tamano_m2) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, nom);
                ps.setDouble(2, tam);
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) idBibliotecaDB = rs.getInt(1);
            }

            miBiblioteca = new Biblioteca(nom, tam);
            System.out.println("¡Biblioteca '" + nom + "' guardada en DB!");
        } catch (Exception e) {
            System.out.println("Error al inicializar: " + e.getMessage());
            return;
        }

        int opcion = 0;
        do {
            try {
                System.out.println("\n--- MENÚ GESTIÓN (9no Semestre) ---");
                System.out.println("1. Crear Armario y añadirlo");
                System.out.println("2. Crear Publicación (Libro/Revista/Periódico)");
                System.out.println("3. Listar contenido de la Biblioteca");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Código del armario: ");
                        String c = sc.nextLine();
                        System.out.print("Material (1. MADERA, 2. METAL): ");
                        int m = sc.nextInt();
                        sc.nextLine(); 
                        Material mat = (m == 1) ? Material.MADERA : Material.METALICO;
                        
                        // --- INSERCIÓN EN BD: ARMARIO ---
                        try (Connection con = Conexion.getConexion()) {
                            String sql = "INSERT INTO armarios (codigo, material, biblioteca_id) VALUES (?, ?, ?)";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.setString(1, c);
                            ps.setString(2, mat.toString());
                            ps.setInt(3, idBibliotecaDB);
                            ps.executeUpdate();
                        }
                        
                        miBiblioteca.agregarArmario(new Armario(c, mat));
                        System.out.println("¡Armario '" + c + "' guardado en MySQL!");
                        break;

                    case 2:
                        if (miBiblioteca.getArmarios().isEmpty()) {
                            System.out.println("ERROR: No hay armarios en la DB.");
                            break;
                        }

                        System.out.println("Tipo: 1. Libro | 2. Revista | 3. Periódico");
                        int tipo = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre/Título: ");
                        String nombre = sc.nextLine();

                        Publicacion nuevaPub = null;
                        String tipoString = "";

                        if (tipo == 1) { // LIBRO
                            System.out.print("Autor: "); String au = sc.nextLine();
                            System.out.print("Editorial: "); String ed = sc.nextLine();
                            System.out.print("Año: "); int an = sc.nextInt(); sc.nextLine();
                            nuevaPub = new Libro(nombre, au, ed, an);
                            tipoString = "Libro";
                        } else if (tipo == 2) { // REVISTA
                            System.out.print("Mes: "); String mes = sc.nextLine();
                            System.out.print("Año: "); int anR = sc.nextInt();
                            System.out.print("Categoría (1.TECNICA, 2.MODA, 3.VARIEDADES): ");
                            int cat = sc.nextInt(); sc.nextLine();
                            Tipo t = (cat == 1) ? Tipo.TECNICA : (cat == 2) ? Tipo.MODA : Tipo.VARIEDADES;
                            nuevaPub = new Revista(nombre, mes, anR, t);
                            tipoString = "Revista";
                        } else if (tipo == 3) { // PERIÓDICO
                            System.out.print("Fecha: "); String f = sc.nextLine();
                            nuevaPub = new Periodico(nombre, f);
                            tipoString = "Periodico";
                        }

                        if (nuevaPub != null) {
                            System.out.println("\nSeleccione el ID del Armario destino:");
                            for (int i = 0; i < miBiblioteca.getArmarios().size(); i++) {
                                System.out.println(i + ". Código: " + miBiblioteca.getArmarios().get(i).getCodigo());
                            }
                            int idArm = sc.nextInt(); sc.nextLine();

                            // --- INSERCIÓN COMPLEJA EN BD: PUBLICACIÓN ---
                            try (Connection con = Conexion.getConexion()) {
                                // 1. Insertar en tabla base
                                String sqlP = "INSERT INTO publicaciones (nombre, tipo_publicacion, armario_id) VALUES (?, ?, ?)";
                                PreparedStatement psP = con.prepareStatement(sqlP, Statement.RETURN_GENERATED_KEYS);
                                psP.setString(1, nombre);
                                psP.setString(2, tipoString);
                                psP.setInt(3, idArm + 1); // Simplificación: asumiendo IDs correlativos en DB
                                psP.executeUpdate();
                                
                                ResultSet rsP = psP.getGeneratedKeys();
                                if (rsP.next() && tipo == 1) {
                                    // 2. Si es libro, insertar en tabla libros
                                    String sqlL = "INSERT INTO libros (publicacion_id, autor, editorial, ano) VALUES (?, ?, ?, ?)";
                                    PreparedStatement psL = con.prepareStatement(sqlL);
                                    psL.setInt(1, rsP.getInt(1));
                                    psL.setString(2, ((Libro)nuevaPub).getAutor()); // Necesitas getters en Libro
                                    psL.setString(3, ((Libro)nuevaPub).getEditorial());
                                    psL.setInt(4, ((Libro)nuevaPub).getAno());
                                    psL.executeUpdate();
                                }
                            }
                            
                            miBiblioteca.getArmarios().get(idArm).agregarPublicacion(nuevaPub);
                            System.out.println("¡Publicación persistida en MySQL!");
                        }
                        break;

                    case 3:
                        miBiblioteca.listarBiblioteca();
                        break;
                        
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcion != 4);
    }
}