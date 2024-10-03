package ies.puerto.ejercicio2;

import java.util.Random;

/**
 * Imagina que Harry, Hermione y Ron están buscando Horrocruxes. Cada personaje está representado por un hilo que busca
 * en una ubicación diferente del mundo. El primer hilo que encuentra un Horrocrux debe detener a los demás y terminar
 * la búsqueda. Elige el tiempo de búsqueda de manera aleatoria para cada hilo.
 */

public class BatallaHorrocruxes implements Runnable {
    private String name;
    //private int distance = 0;
    //private static final int GOAL = 100;
    boolean Running = true;
    private static boolean horrocruxEncontrado = false;

    public BatallaHorrocruxes(String name) {
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
