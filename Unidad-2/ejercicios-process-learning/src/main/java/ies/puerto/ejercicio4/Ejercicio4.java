package ies.puerto.ejercicio4;

import java.io.IOException;

public class Ejercicio4 {

    static String [] EXEC_INFO = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "ies.puerto.ejercicio4.Ejercicio04Writter",
            "src/main/java/ies/puerto/ejercicio4/mensaje.txt"
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
