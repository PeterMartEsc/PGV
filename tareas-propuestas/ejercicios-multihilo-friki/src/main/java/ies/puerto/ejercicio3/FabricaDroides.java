package ies.puerto.ejercicio3;

import ies.puerto.ejercicio2.BatallaHorrocruxes;

import java.util.Random;

/**
 * Simula una fábrica de droides en la que se están ensamblando droides de batalla. Un hilo se encarga de ensamblar
 * los droides, mientras que otro hilo se encarga de activarlos. Asegúrate de que los droides no se activen antes de
 * ser completamente ensamblados, usando mecanismos de sincronización entre hilos.
 */
public class FabricaDroides implements Runnable {
    private String name;
    //private int distance = 0;
    //private static final int GOAL = 100;
    boolean Running = true;
    private static boolean horrocruxEncontrado = false;

    public FabricaDroides(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean busquedaAcabada = false;
        long tiempoInicio = System.currentTimeMillis();
        long tiempoBuscar = random.nextInt(10000) + 1000; // Avance aleatorio de 1000 a 10000 milisegundos (1 a 10 seg)

        System.out.println(name+" está buscando");

        while (!busquedaAcabada) {
            if(horrocruxEncontrado){
                busquedaAcabada = true;
            }
            long tiempoFinal = System.currentTimeMillis();
            if ((tiempoFinal-tiempoInicio == tiempoBuscar) && !horrocruxEncontrado) {
                horrocruxEncontrado = true;
                System.out.println(name + " ha encontrado el horrocrux! Venid a destruirlo");
            }

            //try {
            //Thread.sleep(500); // Pausa entre pasos
            //} //catch (InterruptedException e) {
            //e.printStackTrace();
            //}
        }
    }



    public static void main(String[] args) {
        Thread harry = new Thread(new BatallaHorrocruxes("Harry"));
        Thread hermione = new Thread(new BatallaHorrocruxes("Hermione"));
        Thread ron = new Thread(new BatallaHorrocruxes("Ron"));

        harry.start();
        hermione.start();
        ron.start();
    }
}
