package ies.puerto.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consumidor {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> resultado= new ArrayList<>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                resultado.add("EL consumidor recibió: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
