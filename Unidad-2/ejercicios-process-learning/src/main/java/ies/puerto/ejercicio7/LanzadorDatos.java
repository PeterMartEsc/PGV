package ies.puerto.ejercicio7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LanzadorDatos {
    public static void main(String[] args) {

        try(BufferedWriter br = new BufferedWriter(new FileWriter("ejercicio7.txt"))){

            for (int i = 1; i <= 10; i++) {
                br.write("Datos producidos: " +i);
            }

            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
