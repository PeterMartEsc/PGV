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

    private boolean ensamblados = false;
    private boolean activados = false;

    public FabricaDroides(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int aux = 0;

        while(aux < 2){
            if(!ensamblados){
                ensamblados = true;
                aux++;
                System.out.println(name+ " está ensamblando");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(!activados && ensamblados){
                activados = true;
                aux++;
                System.out.println(name + " está activando...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if(activados && ensamblados){
            System.out.println("Droide activado y ensamblado");
        }


    }



    public static void main(String[] args) {
        Thread hilo1 = new Thread(new FabricaDroides("Trabajador 1"));
        Thread hilo2 = new Thread(new FabricaDroides("Trabajador 2"));


        hilo1.start();
        hilo2.start();

    }
}
