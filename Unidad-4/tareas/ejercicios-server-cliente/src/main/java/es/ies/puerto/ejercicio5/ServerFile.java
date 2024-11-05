package es.ies.puerto.ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket serverSocket = new ServerSocket(port);
        initServer(serverSocket);
    }


    public static void initServer(ServerSocket serverSocket){
        try {
            System.out.println("Initing file server ");
            while (true){
                Socket clientSocket = serverSocket.accept();
                new Thread(new FileHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
