package es.ies.puerto.controlador;

import es.ies.puerto.modelo.Hunter;
import es.ies.puerto.modelo.Mapa;
import es.ies.puerto.modelo.Monster;

import java.util.Random;

public class MonsterHunter extends Thread {
    private Hunter hunter;
    private Monster monster;

    private static Mapa mapa = new Mapa(1, 9);
    private final static int TIEMPO_MAXIMO = 20000;
    private static boolean TIEMPO_AGOTADO = false;

    public MonsterHunter(Hunter hunter) {
        this.hunter = hunter;
    }
    public MonsterHunter(Monster monster) {
        this.monster = monster;
    }

    public synchronized static void moverse(Hunter hunter){

        Random random = new Random();
        hunter.setPositionX(random.nextInt(mapa.getTamanio()));
        hunter.setPositionY(random.nextInt(mapa.getTamanio()));

        System.out.println(hunter.getNombre() + " se movió a: X=" +hunter.getPositionX()+" Y=" +hunter.getPositionY());

        mapa.setHunterPositionX(hunter.getPositionX());
        mapa.setHunterPositionY(hunter.getPositionY());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void explorar(Hunter hunter, Monster monster){
        if(mapa.getHunterPositionX() == mapa.getMonsterPositionX() && mapa.getHunterPositionY() == mapa.getMonsterPositionY()){
            if(mapa.pelea()){
                System.out.println(hunter.getNombre() + " ha capturado a " + monster.getName());
                hunter.setMonstruosAtrapados(1);
            } else {
                System.out.println(monster.getName() + " ha despistado a " + hunter.getNombre());
            }
        }

        System.out.println(hunter.getNombre()+ " sigue buscando");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        //Random random = new Random();
        //Monster rathalos = new Monster(1, "Rathalos", random.nextInt(9), random.nextInt(9));
        Monster rathalos = new Monster(1, "Rathalos",9, 9);
        Hunter maxi = new Hunter(1, "Maxi",0 , 0,0);

        mapa.setHunterPositionX(maxi.getPositionX());
        mapa.setHunterPositionY(maxi.getPositionY());
        mapa.setMonsterPositionX(rathalos.getPositionX());
        mapa.setMonsterPositionY(rathalos.getPositionY());

        Thread cazador1 = new Thread(new MonsterHunter(maxi));
        Thread monstruo1 = new Thread(new MonsterHunter(rathalos));

        cazador1.start();
        monstruo1.start();

        long tiempoInicio = System.currentTimeMillis();

        while(maxi.getMonstruosAtrapados() == 0 && !TIEMPO_AGOTADO){
            long tiempoActual = System.currentTimeMillis();

            moverse(maxi);
            explorar(maxi, rathalos);

            if(tiempoActual - tiempoInicio >= TIEMPO_MAXIMO){
                System.out.println("Se ha acabado el tiempo");
                TIEMPO_AGOTADO = true;
            }
        }

        System.out.println("La cacería ha terminado " + maxi.getNombre() + " ha cazado " +maxi.getMonstruosAtrapados());

    }
}
