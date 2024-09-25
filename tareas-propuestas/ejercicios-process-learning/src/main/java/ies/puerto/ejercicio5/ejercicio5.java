package ies.puerto.ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ejercicio5 {

    public static final String COMMAND = "dir";

    public static void main(String[] args) {
        System.out.println(redirigirFallos(COMMAND));
    }

    public static boolean redirigirFallos(String comando){
        //Crea el proceso
        ProcessBuilder pb = new ProcessBuilder(comando.split(" "));
        pb.redirectErrorStream(true);   //Se redirigen el ¿Stream de Errores?

        try {
            Process proceso = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream())); //Que es el inputStreamReader
            String lineError;

            List<String> errorList = new ArrayList<>();

            while ((lineError = br.readLine()) != null) {
                errorList.add(lineError);
            }

            int exitCode = proceso.waitFor();
            if (exitCode == 1 && !errorList.isEmpty()){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
}
