package es.ies.puerto.exercise.four;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Warrior implements Runnable{

    private String name;
    private static final int MAX_ALLOWANCES = 3;
    private static final Semaphore warriorSemaphore = new Semaphore(MAX_ALLOWANCES);
    public Warrior(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            warriorSemaphore.acquire();
            System.out.println(name + " has entered Valhalla");
            try {
                System.out.println(name + " is looking for a seat");
                Thread.sleep(random.nextInt(500) + 500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            warriorSemaphore.release();
            System.out.println(name + " has found a seat");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
