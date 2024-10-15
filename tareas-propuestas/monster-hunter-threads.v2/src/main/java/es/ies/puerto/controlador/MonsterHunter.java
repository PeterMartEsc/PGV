package es.ies.puerto.controlador;

import es.ies.puerto.modelo.Hunter;
import es.ies.puerto.modelo.Mapa;
import es.ies.puerto.modelo.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MonsterHunter extends Thread {
    private Hunter hunter;
    private Monster monster;

    private static ArrayList<String> nombresMonsters;
    //private static ArrayList<String> nombresHunters;
    private static Mapa mapa = new Mapa(1, 9);
    private final static int TIEMPO_MAXIMO = 60000;
    private static boolean TIEMPO_AGOTADO = false;

    public MonsterHunter(Hunter hunter) {
        this.hunter = hunter;
    }
    public MonsterHunter(Monster monster) {
        this.monster = monster;
    }


    public static void main(String[] args) {

        generarMonstruos();
        generarHunters();

        long tiempoInicio = System.currentTimeMillis();

        while(!TIEMPO_AGOTADO){
            long tiempoActual = System.currentTimeMillis();

            for(Hunter hunter : mapa.getListaHunters().values()){
                moverHunter(hunter);
                for(Monster monster : mapa.getListaMonsters().values()){
                    moverMonster(monster);
                }
            }

            if(tiempoActual - tiempoInicio >= TIEMPO_MAXIMO){
                System.out.println("Se ha acabado el tiempo");
                TIEMPO_AGOTADO = true;
            }

        }

        System.out.println("¡¡¡¡¡La cacería ha terminado!!!!!");

        for(Hunter hunter : mapa.getListaHunters().values()){
            System.out.println(hunter.getNombre() + " ha cazado " +hunter.getMonstruosAtrapados());
        }

        System.out.println("Han sobrevivido: " +mapa.getListaMonsters().size() +" monstruos");
        //System.out.println("Los cazadores supervivientes son: " +mapa.getListaHunters().values());
    }

    public static void generarMonstruos(){

        Random random = new Random();
        nombresMonsters = new ArrayList<>(Arrays.asList("Rathalos", "Wyvern", "Relicto", "Gore Magala", "Laviente", "Laviente Berserker", "Raphinos", "Shogun Ceanataur"));
        int vueltasAleatorias = (int) (Math.random() * 5) + 1;

        for(int i = 0 ;  i<=vueltasAleatorias ; i++){
            int X = random.nextInt(mapa.getTamanio());
            int Y = random.nextInt(mapa.getTamanio());

            while(mapa.hayMonstruo(X, Y)){
                X = random.nextInt(mapa.getTamanio());
                Y = random.nextInt(mapa.getTamanio());
            }
            Monster monster = new Monster(i, nombresMonsters.get(random.nextInt(nombresMonsters.size())), X, Y);
            mapa.agregarMonstruo(monster);

            Thread monstruo = new Thread(new MonsterHunter(monster));
            monstruo.start();
        }

        System.out.println("Se han generado: " +mapa.getListaMonsters().size()+ " monstruos");
    }

    public static void generarHunters(){

        Random random = new Random();
        //nombresHunters = new ArrayList<>(Arrays.asList("Maxi", "Pedro", "Relicto", "Gore Magala", "Laviente", "Laviente Berserker", "Raphinos", "Shogun Ceanataur"));
        int vueltasAleatorias = (int) (Math.random() * 5) + 1;
        for(int i = 0 ;  i<=vueltasAleatorias ; i++){

            int X = random.nextInt(mapa.getTamanio());
            int Y = random.nextInt(mapa.getTamanio());

            while(mapa.hayHunter(X, Y)){
                X = random.nextInt(mapa.getTamanio());
                Y = random.nextInt(mapa.getTamanio());
            }

            Hunter hunter = new Hunter(i, "Cazador "+(i+1),0 , X, Y);
            mapa.agregarHunter(hunter);

            Thread cazador = new Thread(new MonsterHunter(hunter));
            cazador.start();
        }

        System.out.println("Se han generado: " +mapa.getListaHunters().size()+ " cazadores");

    }

    public synchronized static void moverHunter(Hunter hunter){

        Random random = new Random();

        int X = random.nextInt(mapa.getTamanio());
        int Y = random.nextInt(mapa.getTamanio());

        while(mapa.hayHunter(X, Y)){
            X = random.nextInt(mapa.getTamanio());
            Y = random.nextInt(mapa.getTamanio());
        }

        hunter.setPositionX(X);
        hunter.setPositionY(Y);

        System.out.println(hunter.getNombre() + " se movió a: X=" +hunter.getPositionX()+" Y=" +hunter.getPositionY());

        mapa.agregarHunter(hunter);
        explorar(hunter);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void moverMonster(Monster monster){

        Random random = new Random();

        int X = random.nextInt(mapa.getTamanio());
        int Y = random.nextInt(mapa.getTamanio());

        while(mapa.hayMonstruo(X, Y)){
            X = random.nextInt(mapa.getTamanio());
            Y = random.nextInt(mapa.getTamanio());
        }

        monster.setPositionX(X);
        monster.setPositionY(Y);

        System.out.println(monster.getName() + " se movió a: X=" +monster.getPositionX()+" Y=" +monster.getPositionY());

        mapa.agregarMonstruo(monster);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static void explorar(Hunter hunter){
        for(Monster monster : mapa.getListaMonsters().values()){
            if(hunter.getPositionX() == monster.getPositionX() && hunter.getPositionY() == monster.getPositionY()){
                boolean caza = mapa.pelea();
                if(caza){
                    System.out.println(hunter.getNombre() + " ha cazado a " + monster.getName());
                    hunter.setMonstruosAtrapados(hunter.getMonstruosAtrapados()+1);
                    mapa.eliminarMonstruo(monster);
                } else {
                    /*System.out.println(hunter.getNombre() + " ha sucumbido ante " +  monster.getName());
                    mapa.eliminarHunter(hunter);*/
                    System.out.println(monster.getName() + " ha escapado de " +hunter.getNombre());
                }
            }
        }

        System.out.println(hunter.getNombre()+ " no ha encontrado nada");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
