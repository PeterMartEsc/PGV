package ies.puerto.ejercicio4;

import java.util.Random;

public class PartidoQuidditch implements Runnable {
    private String name;
    private boolean buscador;
    private int puntos = 0;

    private int progreso = 0;
    private boolean snitchEncontrada = false;
    private static final int GOAL = 100;

    public PartidoQuidditch(String name, boolean buscador){
        this.name = name;
        this.buscador = buscador;
    }

    public boolean isBuscador() {
        return buscador;
    }

    @Override
    public void run() {
        Random random = new Random();

        while(!snitchEncontrada){

            if(!buscador){
                int tiro = random.nextInt(10) + 1;
                puntos += tiro;
                System.out.println(name+ " ha marcado " + tiro + " puntos");
            }

            if(buscador){
                int busqueda = random.nextInt(10) + 1;
                progreso += busqueda;
                System.out.println("Progreso para encontrar la snitch: " +progreso + "%");
                if(progreso == GOAL){
                    System.out.println("¡Snitch encontrada!");
                    snitchEncontrada = true;
                }
            }
        }

        System.out.println("Puntuación final: " + puntos);
    }

    public static void main(String[] args) {
        Thread jugador1 = new Thread(new PartidoQuidditch("Oliver", false));
        Thread jugador2 = new Thread(new PartidoQuidditch("Cormac", false));
        Thread buscador = new Thread(new PartidoQuidditch("Harry", true));

        jugador1.start();
        jugador2.start();
        buscador.start();
    }

}
