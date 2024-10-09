package es.ies.puerto;

import es.ies.puerto.modelo.Hunter;
import es.ies.puerto.modelo.Mapa;
import es.ies.puerto.modelo.Monster;

import java.util.HashMap;

public class MonsterHunter {

    private final static boolean TIEMPO_AGOTADO = false;




    public class JuegoCazadores {
        public static void main(String[] args) {
            Thread maxi = new Thread((Runnable) new Hunter());
            Thread dragon = new Thread((Runnable) new Monster());

        }
    }
}
