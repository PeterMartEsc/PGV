package es.ies.puerto.controlador;

import es.ies.puerto.modelo.Hunter;
import es.ies.puerto.modelo.Mapa;
import es.ies.puerto.modelo.Monster;

import java.util.HashMap;
import java.util.Random;

public class MonsterHunter extends Thread {
    private Hunter hunter;
    private Monster monster;

    private static Mapa mapa = new Mapa(1);
    private final static int TIEMPO_MAXIMO = 20000;
    private final static boolean TIEMPO_AGOTADO = false;

    public MonsterHunter(Hunter hunter) {
        this.hunter = hunter;
    }
    public MonsterHunter(Monster monster) {
        this.monster = monster;
    }

    public synchronized static void moverse(Hunter hunter){
        Random random = new Random();
        int movimientoX = random.nextInt(9);
        int movimientoY = random.nextInt(9);
        hunter.setPositionX(movimientoX);
        hunter.setPositonY(movimientoY);

        //mapa.agregarHunter();

    }

    public static void main(String[] args) {

        Hunter maxi = new Hunter(1, "Maxi",0 , 0,0);
        Monster rathalos = new Monster(1, "Rathalos", 9, 9);

        mapa.agregarHunter(maxi);
        mapa.agregarMonstruo(rathalos);

        Thread cazador1 = new Thread(new MonsterHunter(maxi));
        Thread monstruo1 = new Thread(new MonsterHunter(rathalos));

        cazador1.start();
        monstruo1.start();

        moverse(maxi);

    }
}
