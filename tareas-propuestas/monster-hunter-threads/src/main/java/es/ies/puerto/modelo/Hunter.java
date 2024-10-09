package es.ies.puerto.modelo;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Hunter {
    private int id;
    private String nombre;
    private int monstruosAtrapados;

    private int positionX;

    private int positonY;

    public Hunter(int id, String nombre, int monstruosAtrapados, int positionX, int positonY) {
        this.id = id;
        this.nombre = nombre;
        this.monstruosAtrapados = monstruosAtrapados;
        this.positionX = positionX;
        this.positonY = positonY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMonstruosAtrapados() {
        return monstruosAtrapados;
    }

    public void setMonstruosAtrapados(int monstruosAtrapados) {
        this.monstruosAtrapados = monstruosAtrapados;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositonY() {
        return positonY;
    }

    public void setPositonY(int positonY) {
        this.positonY = positonY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hunter hunter = (Hunter) o;
        return id == hunter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", monstruosAtrapados=" + monstruosAtrapados +
                ", positionX=" + positionX +
                ", positonY=" + positonY +
                '}';
    }
}
