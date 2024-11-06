package es.ies.puerto.exercise.five;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        Sorcerer.sorcerers.add(new Sorcerer("Emet-Selch", 100));
        Sorcerer.sorcerers.add(new Sorcerer("Alphinaud", 100));
        Sorcerer.sorcerers.add(new Sorcerer("Alisaie", 100));
        Sorcerer.sorcerers.add(new Sorcerer("Y'shtola", 100));

            List<Thread> threads = new ArrayList<>();
            for (Sorcerer sorcerer : Sorcerer.sorcerers) {
                Thread thread = new Thread(sorcerer);
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Game over!");
    }
}
