package ies.puerto.ejercicio7;

import ies.puerto.ejercicio1.BatallaPokemon;

import java.util.Random;

public class SuperheroeSalvando implements Runnable {
    private String name;
    private int progreso = 0;

    private static final int CIUDAD_SALVADA = 100;
    private static boolean salvadorDeclarado = false;

    public SuperheroeSalvando(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progreso < CIUDAD_SALVADA && !salvadorDeclarado) {

            int porcentajeSalvado = random.nextInt(100) + 1; // Daño aleatorio de 1 a 10
            progreso += porcentajeSalvado;
            System.out.println(name + " salvó un " + porcentajeSalvado + "% de la ciudad. Progreso al " + progreso + "%");

            if (progreso >= CIUDAD_SALVADA && !salvadorDeclarado) {
                salvadorDeclarado = true;
                System.out.println(name + " ha salvado la ciudad");
            }

            try {
                Thread.sleep(1000); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread superheroe1 = new Thread(new SuperheroeSalvando("Superman"));
        Thread superheroe2 = new Thread(new SuperheroeSalvando("Batman"));

        superheroe1.start();
        superheroe2.start();
    }
}
