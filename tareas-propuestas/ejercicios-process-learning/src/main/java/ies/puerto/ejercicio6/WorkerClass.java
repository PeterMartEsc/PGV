package ies.puerto.ejercicio6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerClass {

    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }

        String filename = args[0];
        int numberOfProcesses;

        try {
            numberOfProcesses = Integer.parseInt(args[1]);
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
            for(int i = 1 ; i<= numberOfProcesses; i++){
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write("Este archivo ha sido trabajado" + i + "veces" + System.lineSeparator());
                }
            }

            System.out.println("Mensaje escrito en " + filename);
        } catch (IOException e) {
            System.err.println("Ocurrió un error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
}
