package ies.puerto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateInstances {
    public static void main(String[] args) {
        // Comando para ejecutar una clase Java desde otra clase Java
        ProcessBuilder pb = new ProcessBuilder("java", "ClaseSecundaria");

        // Establecer el directorio donde se encuentra la clase compilada
        pb.directory(new java.io.File("./CreateFile"));

        try {
            Process proceso = pb.start();

            // Capturar la salida de la clase ejecutada
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar a que termine el proceso
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
