/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibonaci f = new Fibonaci(0); 
        int opcion;
        boolean nEstablecido = false;

        do {
            System.out.println("\n=======================================");
            System.out.println("  SISTEMA DE CÁLCULOS MATEMÁTICOS");
            System.out.println("=======================================");
            System.out.println("1. Introducir n");
            System.out.println("2. Calcular el Fibonacci (Serie completa)");
            System.out.println("3. Calcular el factorial");
            System.out.println("4. Calcular Sumatoria");
            System.out.println("5. Salir");
            System.out.println("---------------------------------------");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();

            if (opcion >= 2 && opcion <= 4 && !nEstablecido) {
                System.out.println("\n Primero debe ingresar el numer");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el valor de n: ");
                    int nuevoN = sc.nextInt();
                    if (nuevoN < 0) {
                        System.out.println("Error: El número no puede ser negativo.");
                    } else {
                        f.setNum(nuevoN);
                        nEstablecido = true;
                        System.out.println(" El valor " + nuevoN + " ha sido guardado correctamente.");
                    }
                    break;

                case 2:
                    System.out.println("Serie para n=" + f.getNum() + ": " + f.seriafibo());
                    break;

                case 3:
                  
                    System.out.println(f.getNum() + "! = " + f.factorial());
                    break;

                case 4:
                    System.out.println("Suma de 1 hasta " + f.getNum() + ": " + f.sumatoria());
                    break;

                case 5:
                    System.out.println("\nFinalizando programa. ¡Buen día, David!");
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente con un número del 1 al 5.");
            }
        } while (opcion != 5);
    }
}