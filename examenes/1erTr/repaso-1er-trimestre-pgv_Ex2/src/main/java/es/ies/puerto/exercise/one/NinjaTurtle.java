package es.ies.puerto.exercise.one;

import java.util.Random;

public class NinjaTurtle implements Runnable {
    String name;
    int distanceAdvanced = 0;
    public static int OBJETIVE = 100;
    public static boolean isOver = false;

    public NinjaTurtle(String name) {
        this.name = name;
        this.distanceAdvanced = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        System.out.println(name + " started running");

        while(!isOver){
            int distanceAdd = random.nextInt(10)+1;
            distanceAdvanced+=distanceAdd;

            if (distanceAdvanced % 10 == 0){
                System.out.println(name + " has advanced " + distanceAdvanced + " meters");
            }

            if (distanceAdvanced >= OBJETIVE && !isOver){
                synchronized (NinjaTurtle.class) {
                    if (!isOver) {
                        isOver = true;
                        System.out.println(name + " finished the competition first!");
                    }
                }
                break;
            }

            try {
                Thread.sleep(random.nextInt(500) + 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
