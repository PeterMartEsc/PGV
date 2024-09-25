package ies.puerto.ejercicio7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataConsumer {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> result= new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                result.add("Consumer received: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
