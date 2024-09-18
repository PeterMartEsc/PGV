package ies.puerto;

//import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFile {
    String mensaje = "Mensaje como parámetro";

    //Comprobar si existe el archivo
    //Si no existe crearlo
    //Pasar mensaje como parámetro

    //Usar el bufferer reader

    public void crearEscribirFile(){

        String fileName = "mensaje.txt";
        String encoding = "UTF-8";
        try {
            PrintWriter writer = new PrintWriter(fileName, encoding);
            writer.println(mensaje);
            writer.close();
        } catch (IOException e) {
            System.out.println("No se ha podido crear ni escribir el archivo");
            e.printStackTrace();
        }
    }


}