package es.ies.puerto.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Diseña un servidor que reciba dos números enteros de un cliente, los sume y devuelva el resultado.
 * El cliente deberá enviar los dos números separados por un espacio.

 * Por ejemplo, si envía 5 7, el servidor deberá responder 12.
 */
public class ClienteSuma {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 1234;

        Socket socket = null;

        try {

            socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String userInput;

            while (!(userInput = console.readLine()).equals("terminar")) {
                out.println(userInput);
                System.out.println("Respuesta del servidor: " + in.readLine());
            }


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
