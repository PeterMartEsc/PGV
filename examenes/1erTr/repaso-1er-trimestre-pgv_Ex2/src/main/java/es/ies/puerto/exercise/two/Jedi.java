package es.ies.puerto.exercise.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Jedi {
    public static final List<String> attendanceList = Collections.synchronizedList(new ArrayList<>());
    private static final Random random = new Random();

    public static void registerAttendance(String jediName){
        try {
            int registrationTime = random.nextInt(3) + 1;

            System.out.println(jediName + " is registering his attendance..." +
                    " (Time: " + registrationTime + " seconds)");
            Thread.sleep(registrationTime * 1000);

            attendanceList.add(jediName);
            System.out.println(">> " + jediName + " has registered attendance.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}
