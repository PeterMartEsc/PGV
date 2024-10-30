package ies.puerto.ejercicio6;

import ies.puerto.ejercicio5.JediExploradores;

import java.util.Random;

public class SimulacionTardis implements Runnable{

    private String name;

    private static boolean destinoAlcanzado = false;

    private static boolean ganadorDeclarado = false;



    public SimulacionTardis(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        Random random = new Random();
        long tiempoInicio = System.currentTimeMillis();
        long tiempoViaje = random.nextInt(10000) + 1000; // Avance aleatorio de 1000 a 10000 milisegundos (1 a 10 seg)

        System.out.println(name+" está viajando");

        while (!destinoAlcanzado) {
            if(ganadorDeclarado){
                destinoAlcanzado = true;
            }
            long tiempoFinal = System.currentTimeMillis();
            if ((tiempoFinal-tiempoInicio == tiempoViaje) && !ganadorDeclarado) {
                ganadorDeclarado = true;
                System.out.println(name + " ha llegado a su destino, es el ganador.");
            }

            //try {
            //Thread.sleep(500); // Pausa entre pasos
            //} //catch (InterruptedException e) {
            //e.printStackTrace();
            //}
        }

    }

    public static void main(String[] args) {
        Thread pedro = new Thread(new SimulacionTardis("Pedro"));
        Thread maxi = new Thread(new SimulacionTardis("Maxi"));

        pedro.start();
        maxi.start();
    }
}
