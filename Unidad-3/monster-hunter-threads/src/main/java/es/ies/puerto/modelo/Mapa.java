package es.ies.puerto.modelo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

//Mapa contiene posiciṕon del cazador y del moinstruo
//Metodos de colocar cazador y monstruo
//Metodo mover cazador

public class Mapa {

    private int mapId;
    private int hunterPositionX;
    private int hunterPositionY;
    private int monsterPositionX;
    private int monsterPositionY;

    private int tamanio;

    /*public Mapa(int mapId) {
        this.mapId = mapId;
    }*/

    public Mapa(int mapId, int tamanio) {
        this.mapId = mapId;
        this.tamanio = tamanio;
    }

    /*public Mapa(int mapId, int hunterPositionX, int hunterPositionY, int monsterPositionX, int monsterPositionY) {
        this.mapId = mapId;
        this.hunterPositionX = hunterPositionX;
        this.hunterPositionY = hunterPositionY;
        this.monsterPositionX = monsterPositionX;
        this.monsterPositionY = monsterPositionY;
    }*/

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getHunterPositionX() {
        return hunterPositionX;
    }

    public void setHunterPositionX(int hunterPositionX) {
        this.hunterPositionX = hunterPositionX;
    }

    public int getHunterPositionY() {
        return hunterPositionY;
    }

    public void setHunterPositionY(int hunterPositionY) {
        this.hunterPositionY = hunterPositionY;
    }

    public int getMonsterPositionX() {
        return monsterPositionX;
    }

    public void setMonsterPositionX(int monsterPositionX) {
        this.monsterPositionX = monsterPositionX;
    }

    public int getMonsterPositionY() {
        return monsterPositionY;
    }

    public void setMonsterPositionY(int monsterPositionY) {
        this.monsterPositionY = monsterPositionY;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    /*public synchronized void agregarMonstruo(Monster monster){
        positionsMonster.put(monster.getPositionX(), monster.getPositionY());
    }

    public synchronized void agregarHunter(Hunter hunter){
        positionsHunter.put(hunter.getPositionX(), hunter.getPositonY());
    }*/

    public boolean pelea(){
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
                ", hunterPositionX=" + hunterPositionX +
                ", hunterPositionY=" + hunterPositionY +
                ", monsterPositionX=" + monsterPositionX +
                ", monsterPositionY=" + monsterPositionY +
                ", tamanio=" + tamanio +
                '}';
    }
}
