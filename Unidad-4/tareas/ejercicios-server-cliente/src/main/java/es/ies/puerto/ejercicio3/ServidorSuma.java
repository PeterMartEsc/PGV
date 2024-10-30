package es.ies.puerto.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSuma {
    public static void main(String[] args){

        int port = 1234;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port);


            clientSocket = serverSocket.accept();  // Espera una conexión de cliente
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Recibido: " + message);
                String[] numeros = message.split(" ");
                int num1 = Integer.parseInt(numeros[0]);
                int num2 = Integer.parseInt(numeros[1]);

                int resultado = num1 + num2;

                out.println("Resultado de la suma: " + resultado);  // Responde al cliente
            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
