package com.sis258.server.hola.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHolaTcp {

    public static void main(String[] args) {
        int port = 5002;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Servidor iniciado en el puerto " + port);

            while (true) {
                
                Socket client = server.accept();
                System.out.println("\n[CONECTADO] Cliente desde: " + client.getInetAddress());

                try {
                    BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintStream toClient = new PrintStream(client.getOutputStream());

                    String recibido;
                    
                    while ((recibido = fromClient.readLine()) != null) {
                        System.out.println("Mensaje recibido: " + recibido);

                        // Invertir y responder
                        String invertida = new StringBuilder(recibido).reverse().toString();
                        toClient.println(invertida);
                        System.out.println("Respuesta enviada: " + invertida);
                    }

                    // Si sale del bucle es porque readLine() devolvió null
                    System.out.println("[DESCONECTADO] El cliente cerró la conexión de forma limpia.");

                } catch (IOException ex) {
                    // Si ocurre un error de red brusco (ej: cable desconectado o cierre forzado)
                    System.out.println("[ERROR] Conexión perdida abruptamente: " + ex.getMessage());
                } finally {
                    // Asegurarnos de cerrar el socket de este cliente
                    client.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error en el servidor: " + ex.getMessage());
        }
    }
}