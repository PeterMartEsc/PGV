package es.ies.puerto.ejercicio4;

import java.io.*;
import java.net.*;

/**
 * Implementa un servidor de chat donde múltiples clientes puedan conectarse y chatear entre ellos.
 * El servidor debe reenviar cada mensaje que reciba a todos los clientes conectados.

 * Gestionar múltiples conexiones simultáneas con Thread y enviar datos a varios clientes.
 */

public class ClienteEnLinea {
    public static void main(String[] args) {

        System.out.println("Cliente de chat iniciado...");

        try (Socket socket = new Socket("localhost", 1234);

             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            Thread readThread = new Thread(() -> {

                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Mensaje: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
