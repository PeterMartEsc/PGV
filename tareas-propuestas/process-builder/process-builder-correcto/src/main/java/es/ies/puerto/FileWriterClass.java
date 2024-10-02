package es.ies.puerto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileWriterClass {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java FileWriterClass <filename> <message> <number_of_processes>");
            return;
        }

        String filename = args[0];
        String message = args[1];
        int numberOfProcesses;

        try {
            numberOfProcesses = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("El número de procesos debe ser un entero.");
            return;
        }

        File file = new File(filename);

        // Crea el archivo y escribe el mensaje
        try {
            // Si el archivo no existe, lo crea
            if (!file.exists()) {
                file.createNewFile();
            }

            // Escribe el mensaje en el archivo
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(message + numberOfProcesses + System.lineSeparator());
            }

            System.out.println("Mensaje escrito en " + filename);
        } catch (IOException e) {
            System.err.println("Ocurrió un error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
}
