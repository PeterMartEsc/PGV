package ies.puerto.ejercicio5;


import java.util.Random;

/**
 * Crea una simulación donde dos exploradores Jedi, representados por hilos, viajan por el espacio buscando
 * pistas sobre el Lado Oscuro. Cada hilo busca en diferentes planetas, y el primer explorador que encuentre
 * una pista debe detener al otro. Implementa tiempos de búsqueda aleatorios para cada Jedi.
 */
public class JediExploradores implements Runnable {

    private String name;

    private static boolean investigacionAcabada = false;

    public JediExploradores(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean busquedaAcabada = false;
        long tiempoInicio = System.currentTimeMillis();
        long tiempoBuscar = random.nextInt(10000) + 1000; // Avance aleatorio de 1000 a 10000 milisegundos (1 a 10 seg)

        System.out.println(name+" está buscando pistas del Lado Oscuro");

        while (!busquedaAcabada) {
            if(investigacionAcabada){
                busquedaAcabada = true;
            }

            long tiempoFinal = System.currentTimeMillis();
            if ((tiempoFinal-tiempoInicio == tiempoBuscar) && !investigacionAcabada) {
                investigacionAcabada = true;
                System.out.println(name + " ha terminado de investigar! Reunamonos en Naboo");
            }
        }
    }

    public static void main(String[] args) {
        Thread anakin = new Thread(new JediExploradores("Anakin"));
        Thread obiWan = new Thread(new JediExploradores("Obi Wan"));

        anakin.start();
        obiWan.start();
    }
}
