package ies.puerto.ejercicio1;

import java.util.Random;

/**
 * Crea una simulación de batalla Pokémon en la que dos Pokémon (Pikachu y Charmander) luchan entre sí. Cada hilo
 * representa a un Pokémon que alterna ataques y recibe daño hasta que uno de ellos se queda sin puntos de vida (HP).
 * Deberás lanzar dos hilos y hacer que se detengan cuando uno de los Pokémon gane.
 */
public class BatallaPokemon implements Runnable {
    private String name;
    private int vida = 100;

    private static final int FIN_PARTIDA = 0;
    private static boolean winnerDeclared = false;

    public BatallaPokemon(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (vida > FIN_PARTIDA && !winnerDeclared) {

            int danio = random.nextInt(10) + 1; // Daño aleatorio de 1 a 10
            vida -= danio;
            System.out.println(name + " recibió " + danio + " puntos de daño. Vida actual: " + vida + " PH.");

            if (vida <= FIN_PARTIDA && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha ganado la pelea!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread pikachu = new Thread(new BatallaPokemon("Pikachu"));
        Thread charmander = new Thread(new BatallaPokemon("Charmander"));

        pikachu.start();
        charmander.start();
    }
}
