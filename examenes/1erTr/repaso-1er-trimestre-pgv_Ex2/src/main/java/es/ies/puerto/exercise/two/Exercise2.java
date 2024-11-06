package es.ies.puerto.exercise.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            final int jediId = i;
            executorService.submit(() -> {
                Jedi.registerAttendance("Jedi" + jediId);
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("There are threads that have not finished");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Attendance List: " + Jedi.attendanceList);

    }

}
