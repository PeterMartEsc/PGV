package ies.puerto.ejercicio1.modoPedro;

import java.util.Objects;

public class Pokemon {
    private String name;
    private int vida;

    public Pokemon() {
    }

    public Pokemon(String name) {
        this.name = name;
        this.vida = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon that = (Pokemon) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PokemonClass{" +
                "name='" + name + '\'' +
                ", vida=" + vida +
                '}';
    }
}
