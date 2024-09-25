package ies.puerto.ejercicio6;

import java.io.IOException;

public class Ejercicio6 {

    static String [] EXEC_INFO = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "ies.puerto.ejercicio6.WorkerClass",
            "src/main/java/ies/puerto/ejercicio6/worked.txt",
            "5"
    };

    public static void main(String[] args) {

        System.out.println(ejecutarOtraCLase(EXEC_INFO));
    }


    public static boolean ejecutarOtraCLase(String [] infoExec){

        ProcessBuilder processBuilder = new ProcessBuilder(infoExec);

        try {
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
