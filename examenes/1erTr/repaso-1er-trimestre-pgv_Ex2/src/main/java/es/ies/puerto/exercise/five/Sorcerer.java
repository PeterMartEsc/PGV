package es.ies.puerto.exercise.five;

import java.util.*;

public class Sorcerer implements Runnable{
    private String name;
    private int health;
    private static final int MAX_DAMAGE = 20;
    public static final List<Sorcerer> sorcerers = new ArrayList<>();
    private static boolean isOver = false;
    private  static  final Random random = new Random();

    public Sorcerer(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public synchronized boolean isAlive(){
        return this.health > 0;
    }

    public synchronized void takeDamage(int damage){
        health -= damage;
        if (health <= 0){
            System.out.println(name + " has been defeated!");
            return;
        }

        System.out.println(name + " took " + damage + " damage, remaining hp: " + health);
    }

    public Sorcerer selectRival(){
        Sorcerer rival = null;
        while (rival == null || rival == this || !rival.isAlive()) {
            int index = random.nextInt(sorcerers.size());
            rival = sorcerers.get(index);
        }

        return rival;
    }
    public synchronized boolean attack(Sorcerer rivalSorcerer){
        if (rivalSorcerer.isAlive()){
            int damageDone = random.nextInt(MAX_DAMAGE)+1;
            rivalSorcerer.takeDamage(damageDone);
            System.out.println(name + " attacked " + rivalSorcerer.name + " and dealt " + damageDone + " points of damage");
            return true;
        }
        return false;
    }

    public static synchronized int remainingSorcerers(){
        int counter = 0;
        for (Sorcerer sorcerer : sorcerers){
            if (sorcerer.isAlive()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void run() {
        System.out.println(name + " entered the game with " + health + " health ");

        while (isAlive() && !isOver) {
            Sorcerer rivalSorcerer = selectRival();
            if (rivalSorcerer != null && rivalSorcerer != this) {
                boolean attacked = attack(rivalSorcerer);
                if (attacked && remainingSorcerers() == 1) {
                    isOver = true;
                    System.out.println(name + " wins the game!");
                    break;
                }
            }

            try {
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
