package ies.puerto.ejercicio4;

import java.util.Objects;

public class Jugador {

    private String name;

    private int puntuacion;

    private boolean buscador;

    public Jugador() {
    }

    public Jugador(String name, boolean buscador) {
        this.name = name;
        this.buscador = buscador;
    }

    public Jugador(String name, int puntuacion) {
        this.name = name;
        this.puntuacion = puntuacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isBuscador() {
        return buscador;
    }

    public void setBuscador(boolean buscador) {
        this.buscador = buscador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(name, jugador.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "name='" + name + '\'' +
                ", puntuacion=" + puntuacion +
                ", buscador=" + buscador +
                '}';
    }
}
