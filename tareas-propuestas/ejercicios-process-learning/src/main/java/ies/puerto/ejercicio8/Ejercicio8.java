package ies.puerto.ejercicio8;

import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "www.google.com");

        try {
            long tiempoInicio = System.currentTimeMillis();
            Process proceso = pb.start();
            proceso.waitFor();
            long tiempoFinal = System.currentTimeMillis();

            long tiempoEjecucion = tiempoFinal - tiempoInicio;

            System.out.println("El comando ha tardado " + tiempoEjecucion+ " milisegundos");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
