package es.ies.puerto.exercise.abstracts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAbstract {
    public static void startServer(ServerSocket serverSocket){
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message;

                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("stop")) {
                        System.out.println("Stopping server...");
                        return;
                    }
                    System.out.println("Received: " + message);
                    out.println("Response: " + message);
                }

            } catch (IOException e) {
                System.out.println("Exiting...");
                e.printStackTrace();

            } finally {
                try {
                    clientSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
