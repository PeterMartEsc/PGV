package es.ies.puerto.controlador;

import es.ies.puerto.modelo.Hunter;
import es.ies.puerto.modelo.Mapa;
import es.ies.puerto.modelo.Monster;

public class MonsterHunter implements Runnable {

    private static Mapa mapa = new Mapa(1);
    private final static int TIEMPO_MAXIMo = 20000;
    private final static boolean TIEMPO_AGOTADO = false;

    @Override
    public void run() {



    }



    public static void main(String[] args) {

        Hunter maxi = new Hunter(1, "Maxi",0 , 1,1);
        Monster dragon = new Monster(1, "Dragon", 10, 10);

        mapa.agregarHunter(maxi);
        mapa.agregarMonstruo(dragon);

        Thread cazador1 = new Thread((Runnable) maxi);
        Thread monstruo1 = new Thread((Runnable) dragon);

    }
}
