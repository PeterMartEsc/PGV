package es.ies.puerto.caza;

import java.util.Random;

public class MonsterHunter {

    static class Map {
        //Propiedades de Map
        private int positionX;

        private int positionY;


        public Map(int positionX, int positionY) {
            this.positionX = positionX;
            this.positionY = positionY;
        }

        public int getPositionX() {
            return positionX;
        }

        public void setPositionX(int positionX) {
            this.positionX = positionX;
        }

        public int getPositionY() {
            return positionY;
        }

        public void setPositionY(int positionY) {
            this.positionY = positionY;
        }



        @Override
        public String toString() {
            return "Map{" +
                    "positionX=" + positionX +
                    ", positionY=" + positionY +
                    '}';
        }
    }

    static class Monster {
        // Propiedades del monstruo
        private String name;
        private Map position;

        public Monster(String name, Map position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map getPosition() {
            return position;
        }

        public void setPosition(Map position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "Monster{" +
                    "name='" + name + '\'' +
                    ", position=" + position +
                    '}';
        }
    }

    static class Cazador extends Thread {
        private String nombre;
        private int monstruosAtrapados = 0;

        private Map posicion;

        public Cazador(String nombre, int mostruosAtrapados, Map posicion) {
            this.nombre = nombre;
            this.monstruosAtrapados = mostruosAtrapados;
            this.posicion = posicion;
        }

        @Override
        public void run() {
            while (true) {
                // Lógica de movimiento
                // Intentar atrapar un monstruo
                // Aumentar el contador de monstruos atrapados
                try {
                    Thread.sleep(new Random().nextInt(1000)); // Espera aleatoria
                } catch (InterruptedException e) {
                    break; // Terminar el hilo si es interrumpido
                }
            }
        }
    }

    public class JuegoCazadores {
        public static void main(String[] args) {
            Thread maxi = new Thread((Runnable) new Cazador("Maxi", 0, new Map(1, 1)));
            Thread dragon = new Thread((Runnable) new Monster("Dragon", new Map(1, 2)));
        }
    }
}
