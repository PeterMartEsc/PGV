package es.ies.puerto.modelo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

//Mapa contiene posiciṕon del cazador y del moinstruo
//Metodos de colocar cazador y monstruo
//Metodo mover cazador

public class Mapa {

    private int mapId;
    private HashMap<Integer, Integer> positionsMonster;
    private HashMap<Integer, Integer> positionsHunter;


    public Mapa(int mapId) {
        this.mapId = mapId;
    }

    public Mapa(int mapId, HashMap<Integer, Integer> positionsMonster, HashMap<Integer, Integer> positionsHunter) {
        this.mapId = mapId;
        this.positionsMonster = positionsMonster;
        this.positionsHunter = positionsHunter;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public HashMap<Integer, Integer> getPositionsMonster() {
        return positionsMonster;
    }

    public void setPositionsMonster(HashMap<Integer, Integer> positionsMonster) {
        this.positionsMonster = positionsMonster;
    }

    public HashMap<Integer, Integer> getPositionsHunter() {
        return positionsHunter;
    }

    public void setPositionsHunter(HashMap<Integer, Integer> positionsHunter) {
        this.positionsHunter = positionsHunter;
    }

    public synchronized void agregarMonstruo(Monster monster){

        positionsMonster.put(monster.getPositionX(), monster.getPositionY());

    }

    public synchronized void agregarHunter(Hunter hunter){

        positionsHunter.put(hunter.getPositionX(), hunter.getPositonY());

    }

    private boolean pelea(){
        Random random = new Random();
        int result = random.nextInt(1);
        if(result>0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return mapId == mapa.mapId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapId);
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "mapId=" + mapId +
                ", size=" + positionsMonster +
                '}';
    }
}
