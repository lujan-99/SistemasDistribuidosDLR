package com.sis258.client.hola.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHolaTcp {

    public static void main(String[] args) {
        int port = 5002;
        String ip = "10.8.221.103";

        Scanner sc = new Scanner(System.in);
        String opcion;

        try (
            Socket client = new Socket(ip, port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()))
        ) {
            System.out.println("Conectado al servidor.");

            do {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Enviar nueva cadena");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextLine();

                if (opcion.equals("1")) {
                    System.out.print("Introduce la cadena a invertir: ");
                    String cadena = sc.nextLine();

                    // Enviar
                    toServer.println(cadena);

                    // Recibir
                    String respuesta = fromServer.readLine();
                    System.out.println("Respuesta del servidor: " + respuesta);

                } else if (!opcion.equals("2")) {
                    System.out.println("Opción no válida.");
                }

            } while (!opcion.equals("2"));

            // Opcional: avisar al servidor que el cliente se va
            toServer.println("SALIR");

        } catch (IOException ex) {
            System.out.println("Error de conexión: " + ex.getMessage());
        }

        sc.close();
        System.out.println("Programa finalizado.");
    }
}