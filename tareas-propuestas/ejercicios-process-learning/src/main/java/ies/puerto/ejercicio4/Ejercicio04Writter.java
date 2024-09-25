package ies.puerto.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio04Writter {

    public static void main(String[] args) {
        if(args.length < 1){
            return;
        }

        String fileName = args[0];

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
            br.write("Esto es un mensaje");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
