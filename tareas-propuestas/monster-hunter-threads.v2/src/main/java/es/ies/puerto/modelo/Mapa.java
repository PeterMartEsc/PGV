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


}
