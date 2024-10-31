package es.ies.puerto.ejercicio1;

import java.io.*;
import java.net.*;
/**
 * Crea un programa de servidor que escuche en un puerto específico y un cliente que se conecte a este servidor.
 * El cliente enviará un mensaje al servidor, y el servidor le responderá con el mismo mensaje.
 * Objetivo: Familiarizarse con el uso básico de sockets y flujo de datos entre cliente y servidor.
 */

public class Cliente{

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        Socket socket = null;

        sendMessage(socket, port, host);
    }

    public static void sendMessage(Socket socket, int port, String host ){

        try {
            socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String userInput;

            userInput = console.readLine();
            out.println(userInput);
            System.out.println("Respuesta del servidor: " + in.readLine());


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
