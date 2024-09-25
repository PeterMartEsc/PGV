package ies.puerto.ejercicio7;

import java.io.IOException;

public class Ejercicio7 {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
        try {
            long tiempoInicio = System.nanoTime();
            Process proceso = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
