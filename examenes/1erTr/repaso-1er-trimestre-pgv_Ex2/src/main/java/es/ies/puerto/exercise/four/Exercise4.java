package es.ies.puerto.exercise.four;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        List<Warrior> warriors = new ArrayList<>();

        warriors.add(new Warrior("Battler"));
        warriors.add(new Warrior("Willard"));
        warriors.add(new Warrior("Beatrice"));
        warriors.add(new Warrior("Lion"));

        List<Thread> threads = new ArrayList<>();
        for (Warrior warrior : warriors){
            Thread thread = new Thread(warrior);
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


    }
}
