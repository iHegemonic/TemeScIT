package org.Tema10;

import java.util.Arrays;
import java.util.List;

public class FestivalApp {

    public static void startFestival(int numberOfAttendees) {
        FestivalGate gate = new FestivalGate();

        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.setDaemon(true);
        statsThread.start();

        for(int i = 0; i < numberOfAttendees; i++) {
            TicketType ticketType = getRandomTicketType();
            new FestivalAttendeeThread(ticketType, gate).start();
        }

        FestivalApp.keepAppRunning(5100);

    }

    private static TicketType getRandomTicketType() {
       List<TicketType> types = Arrays.stream(TicketType.values()).toList();
       int radomIndex = (int) (Math.random() * types.size());
       return types.get(radomIndex);


    }

    public static void keepAppRunning(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
