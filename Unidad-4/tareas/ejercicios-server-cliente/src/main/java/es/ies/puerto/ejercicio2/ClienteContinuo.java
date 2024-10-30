package es.ies.puerto.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Extiende (ServidorContinua extend Servidor) el ejercicio anterior para que el cliente y el servidor puedan mantener
 * una conversación continua. El cliente podrá enviar varios mensajes al servidor, y el servidor devolverá cada mensaje
 * hasta que el cliente envíe el mensaje "salir", lo cual cerrará la conexión.

 * En este caso debenos de manejar conexiones continuas y gestionar la terminación de la comunicación.
 * Ten en cuenta que debes de:

 *  - Usa un bucle while en el servidor para mantener la conexión abierta.
 *  - Implementa una condición de parada para finalizar el chat.
 */

public class ClienteContinuo {
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
