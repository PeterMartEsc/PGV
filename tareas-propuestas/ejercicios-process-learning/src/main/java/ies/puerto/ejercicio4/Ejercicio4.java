package ies.puerto.ejercicio4;

import java.io.IOException;

public class Ejercicio4 {

    static String [] EXEC_INFO = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "es.ies.puerto.ejercicio4.Ejercicio4Writter",
            "texto.txt"
    };

    public static void main(String[] args) {

        System.out.println(ejecutarOtraCLase(EXEC_INFO));
    }


    public static boolean ejecutarOtraCLase(String [] infoExec){


        try {
            ProcessBuilder processBuilder = new ProcessBuilder(infoExec);
            Process proceso = processBuilder.start();

            int codigoSalida = proceso.waitFor();
            if(codigoSalida == 0){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

}
