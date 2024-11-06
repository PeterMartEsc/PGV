package es.ies.puerto.exercise.one;

public class Exercise1 {

    public static void main(String[] args) {
        NinjaTurtle leonardo = new NinjaTurtle("Leonardo");
        NinjaTurtle donatello = new NinjaTurtle("Donatello");
        NinjaTurtle raphael = new NinjaTurtle("Raphael");
        NinjaTurtle michelangelo = new NinjaTurtle("Michel Angelo");

        Thread threadLeonardo = new Thread(leonardo);
        Thread threadDonatello = new Thread(donatello);
        Thread threadRaphael = new Thread(raphael);
        Thread threadMichelAngelo = new Thread(michelangelo);

        threadLeonardo.start();
        threadDonatello.start();
        threadRaphael.start();
        threadMichelAngelo.start();
    }
}
