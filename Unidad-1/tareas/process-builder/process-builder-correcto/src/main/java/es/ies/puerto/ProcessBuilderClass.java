package es.ies.puerto;

import java.io.IOException;

public class ProcessBuilderClass {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ProcessBuilderClass <number_of_processes> <command>");
            return;
        }

        int numberOfProcesses;
        try {
            numberOfProcesses = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("El número de procesos debe ser un entero.");
            return;
        }

        String command = args[1];

        for (int i = 0; i < numberOfProcesses; i++) {
            //ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // Redirige el error al flujo de salida

            try {
                Process process = processBuilder.start();
                System.out.println("Proceso #" + (i + 1) + " iniciado con el comando: " + command);
                process.waitFor(); // Espera a que el proceso termine
            } catch (IOException | InterruptedException e) {
                System.err.println("Ocurrió un error al iniciar el proceso: " + e.getMessage());
            }
        }
    }
}