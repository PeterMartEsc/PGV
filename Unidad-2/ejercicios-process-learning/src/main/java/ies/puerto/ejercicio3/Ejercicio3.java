package ies.puerto.ejercicio3;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {

    public static void main(String[] args) {
        ProcessBuilder procesoList = new ProcessBuilder("ls", "-l");

        File fileOutput = new File("src/main/java/ies/puerto/Ejercicio3/output.txt");
        procesoList.redirectOutput(fileOutput);
        procesoList.redirectErrorStream(true);

        try {
            Process proceso = procesoList.start();

            int exitCode = proceso.waitFor();
            System.out.println("Código de salida proceso: " + exitCode);


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


