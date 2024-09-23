package ies.puerto.ejercicio2;

import java.io.IOException;

public class ejercicio2 {

    public static void main(String[] args) {
        ProcessBuilder procesoPing = new ProcessBuilder("ping", "-c", "3", "google.com");
        ProcessBuilder procesoList = new ProcessBuilder("ls");
        ProcessBuilder procesoEcho = new ProcessBuilder("echo", "'Hola mundo'");

        try {
            // Iniciar el proceso
            Process proceso1 = procesoPing.start();

            // Esperar a que el proceso termine
            int exitCode1 = proceso1.waitFor();
            System.out.println("Código de salida proceso 1: " + exitCode1);

            Process proceso2 = procesoList.start();
            int exitCode2 = proceso2.waitFor();
            System.out.println("Código de salida proceso 2: " + exitCode2);

            Process proceso3 = procesoEcho.start();
            int exitCode3 = proceso3.waitFor();
            System.out.println("Código de salida proceso 3: " + exitCode3);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
