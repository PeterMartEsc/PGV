package es.ies.puerto.modelo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

//Mapa contiene posiciṕon del cazador y del moinstruo
//Metodos de colocar cazador y monstruo
//Metodo mover cazador

public class Mapa {

    private int mapId;
    private int tamanio;
    private HashMap<Integer, Hunter> listaHunters;
    private HashMap<Integer, Monster> listaMonsters;

    /*public Mapa(int mapId) {
        this.mapId = mapId;
    }*/

    public Mapa(int mapId, int tamanio) {
        this.mapId = mapId;
        this.tamanio = tamanio;
        this.listaHunters = new HashMap<>();
        this.listaMonsters = new HashMap<>();
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public HashMap<Integer, Hunter> getListaHunters() {
        return listaHunters;
    }

    public void setListaHunters(HashMap<Integer, Hunter> listaHunters) {
        this.listaHunters = listaHunters;
    }

    public HashMap<Integer, Monster> getListaMonsters() {
        return listaMonsters;
    }

    public void setListaMonsters(HashMap<Integer, Monster> listaMonsters) {
        this.listaMonsters = listaMonsters;
    }

    public synchronized void agregarHunter(Hunter hunter){
        listaHunters.put(hunter.getId(), hunter);
    }

    public synchronized void agregarMonstruo(Monster monster){
        listaMonsters.put(monster.getId(), monster);
    }

    public synchronized void eliminarHunter(Hunter hunter){
        listaMonsters.remove(hunter.getId());
    }

    public synchronized void eliminarMonstruo(Monster monster){
        listaMonsters.remove(monster.getId());
    }

    public boolean pelea(){
        Random random = new Random();
        int result = random.nextInt(1);
        if(result>0){
            return true;
        } else {
            return false;
        }
    }
    public synchronized boolean hayHunter (int X, int Y){
        boolean hayHunter = false;

        if(listaHunters.isEmpty()){
            return hayHunter;
        }

        for(Hunter hunter : listaHunters.values()){

            if(hunter.getPositionX() == X && hunter.getPositionY() == Y){
                hayHunter = true;
            }
        }

        return hayHunter;
    }
    public synchronized boolean hayMonstruo (int X, int Y){
        boolean hayMonstruo = false;

        if(listaMonsters.isEmpty()){
            return hayMonstruo;
        }

        for(Monster monster : listaMonsters.values()){

            if(monster.getPositionX() == X && monster.getPositionY() == Y){
                hayMonstruo = true;
            }
        }

        return hayMonstruo;
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
                ", tamanio=" + tamanio +
                ", listaHunters=" + listaHunters +
                ", listaMonsters=" + listaMonsters +
                '}';
    }
}
