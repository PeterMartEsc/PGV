package ies.puerto.ejercicio4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio4 {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Se usa: java FileWriterClass <nombre_archivo> <mensaje> <numero_de_procesos>");
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
