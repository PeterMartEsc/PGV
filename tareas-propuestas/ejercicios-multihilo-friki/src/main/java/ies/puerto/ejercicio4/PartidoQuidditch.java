package ies.puerto.ejercicio4;

import ies.puerto.ejercicio1.modoEstandar.BatallaPokemon;

import java.util.Random;

public class PartidoQuidditch implements Runnable {

    private static final int FIN_PARTIDA = 0;

    @Override
    public void run() {
        Random random = new Random();
        if(buscador = true){

        }
    }

    public static void main(String[] args) {
        Thread jugador1 = new Thread((Runnable) new Jugador("Harry", 0));
        Thread jugador2 = new Thread((Runnable) new Jugador("Draco", 0));
        Thread buscador = new Thread((Runnable) new Jugador("Buscador", true));

        jugador1.start();
        jugador2.start();
        buscador.start();
    }

}
