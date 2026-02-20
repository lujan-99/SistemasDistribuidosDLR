/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.figuras;

import java.util.ArrayList;
import java.util.Scanner;

public class Figuras {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<IFigura> listaFiguras = new ArrayList<>();

        int opcion;

        do {
            System.out.println("1 Agregar");
            System.out.println("2 Total");
            System.out.println("3 Salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n¿Qué figura desea agregar?");
                    System.out.println("1. Cuadrado");
                    System.out.println("2. Rectangulo");
                    System.out.println("3. Redondo");
                    System.out.print("Seleccione: ");
                    int tipo = sc.nextInt();

                    switch (tipo) {
                        case 1:
                            System.out.print("Lado ");
                            int lado = sc.nextInt();
                            listaFiguras.add(new Cuadrado(lado));
                            break;

                        case 2:
                            System.out.print("alto ");
                            int alto = sc.nextInt();
                            System.out.print("ancho ");
                            int ancho = sc.nextInt();
                            listaFiguras.add(new Rectangulos(alto, ancho));
                            break;

                        case 3:
                            System.out.print("Iradio");
                            int radio = sc.nextInt();
                            listaFiguras.add(new Redondo(radio));
                            break;

                        default:
                    }
                    break;

                case 2:
                    int suma = 0;
                    for (IFigura figura : listaFiguras) {
                        suma += figura.area();
                    }
                    System.out.println("total " + suma);
                    break;

                case 3:
                    System.out.println("Salir");
                    break;

                default:
            }

        } while (opcion != 3);

        sc.close();
    }
}