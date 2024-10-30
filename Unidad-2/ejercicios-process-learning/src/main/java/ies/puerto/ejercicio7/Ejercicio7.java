package ies.puerto.ejercicio7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio7 {

    static String[] consumirProceso = {"java","-cp","bin",
            "src/main/java/ies/puerto/ejercicio7/Consumidor.java"};
    static String[] lanzarProceso = {"java","-cp","bin",
            "src/main/java/ies/puerto/ejercicio7/LanzadorDatos.java"};

    public static void main(String[] args) {
        System.out.println(lanzarConsumirProcesos(lanzarProceso, consumirProceso));
    }

    public static boolean lanzarConsumirProcesos(String [] execlanzarProceso, String [] execconsumirProceso){

        ProcessBuilder pbProducer = new ProcessBuilder(execlanzarProceso);
        ProcessBuilder pbConsumer = new ProcessBuilder(execconsumirProceso);
        pbProducer.redirectErrorStream(true);
        pbConsumer.redirectErrorStream(true);


        try {
            Process procesoLanzar = pbProducer.start();
            Process consumirProceso = pbConsumer.start();

            InputStream lanzadorInputStream = procesoLanzar.getInputStream();
            OutputStream consumidorOutputStream = consumirProceso.getOutputStream();

            byte[] tmp = new byte[1024];
            int bytesLeidos;

            while ((bytesLeidos = lanzadorInputStream.read(tmp)) != -1) {
                consumidorOutputStream.write(tmp, 0, bytesLeidos);
                consumidorOutputStream.flush();
            }

            lanzadorInputStream.close();
            consumidorOutputStream.close();

            int exitCodeLanzador = procesoLanzar.waitFor();
            int exitCodeConsumidor = consumirProceso.waitFor();

            if (exitCodeLanzador == 0  && exitCodeConsumidor == 0){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            return false;
        }
        return false;
    }
}
