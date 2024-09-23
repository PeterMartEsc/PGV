package ies.puerto.ejercicio1;

import java.io.IOException;

public class ejercicio1 {
    public static void main(String[] args) {
        // Crear un nuevo proceso que ejecuta el comando 'ping'
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com");

        try {
            // Iniciar el proceso
            Process proceso = pb.start();
            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//mvn exec:java -Dexec.mainClass="ies.puerto.ejercicio1" -Dexec.args="1 ping google.com"
