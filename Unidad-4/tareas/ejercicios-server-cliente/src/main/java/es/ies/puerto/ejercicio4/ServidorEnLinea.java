package es.ies.puerto.ejercicio4;

import java.io.*;
import java.net.*;
import java.util.Set;
import java.util.concurrent.*;

public class ServidorEnLinea {

    //Punteros que escribirán en consolas de cada cliente?
    private static final Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) {
        //Inicia servidor
        System.out.println("Servidor de chat iniciado...");

        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            for(int i = 0; i< 4; i++ ){
                new ClientHandler(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            try {

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                String message;

                //Recibe un mensaje y lo manda a todos los clientes
                while ((message = in.readLine()) != null) {
                    System.out.println("Mensaje recibido: " + message);
                    //Se manda el mensaje a todos
                    sendMessageToAllClients(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientWriters.remove(out);
            }
        }

        //Metodo para mandar un mensaje a todos
        private void sendMessageToAllClients(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}
