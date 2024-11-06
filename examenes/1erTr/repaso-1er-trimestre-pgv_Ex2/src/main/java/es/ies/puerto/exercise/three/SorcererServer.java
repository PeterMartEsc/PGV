package es.ies.puerto.exercise.three;

import es.ies.puerto.exercise.abstracts.ServerAbstract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class SorcererServer {
    private static final Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();
    private static final int MAX_CLIENTS_ALLOWED = 3;
    private static final Semaphore connectionSemaphore = new Semaphore(MAX_CLIENTS_ALLOWED);

    public static void main(String[] args) {
        System.out.println("Chat server init...");

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            startServer(serverSocket);
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }


    public static void startServer(ServerSocket serverSocket){
        while (true) {
            try {
                connectionSemaphore.acquire();
                new SorcererHandler(serverSocket.accept()).start();
                System.out.println("New client connected. Total clients: " +
                        (MAX_CLIENTS_ALLOWED - connectionSemaphore.availablePermits()));
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static class SorcererHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public SorcererHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Message received: " + message);
                    sendMessageToAllClientsConnected(message);
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
                connectionSemaphore.release();
                System.out.println("Client disconnected. Total clients: " +
                        (MAX_CLIENTS_ALLOWED - connectionSemaphore.availablePermits()));            }
        }
        private void sendMessageToAllClientsConnected(String message) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}
