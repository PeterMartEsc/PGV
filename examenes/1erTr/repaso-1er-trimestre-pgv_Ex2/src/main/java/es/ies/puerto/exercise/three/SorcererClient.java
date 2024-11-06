package es.ies.puerto.exercise.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SorcererClient extends Thread {

    public static void main(String[] args) {
        init();
    }

    public static void init(){
        try {
            Socket socket = new Socket("localhost", 12345);
            startClientThread(socket);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void startClientThread(Socket socket){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            Thread readThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {

                        System.out.println("Message: " + response);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from server: " + e.getMessage());
                }
            });

            readThread.start();

            System.out.println("Enter messages to send to the chat:");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            System.err.println("Error in client communication: " + e.getMessage());        }
    }
}
