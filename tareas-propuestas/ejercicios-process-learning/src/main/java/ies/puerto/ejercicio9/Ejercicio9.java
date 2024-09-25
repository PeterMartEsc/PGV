package ies.puerto.ejercicio9;

import java.io.IOException;

public class Ejercicio9 {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("ping", "-t" ,"www.google.com");

        try {
            Process proceso = pb.start();
            long tiempoInicio = System.currentTimeMillis();
            boolean ejecutandose = true;

            while(ejecutandose){
                long tiempoActual = System.currentTimeMillis();
                if((tiempoActual - tiempoInicio) > 10000){
                    proceso.destroy();
                    ejecutandose = false;
                }
            }

            proceso.waitFor();

            //System.out.println("El comando ha tardado " + tiempoEjecucion+ " milisegundos");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
