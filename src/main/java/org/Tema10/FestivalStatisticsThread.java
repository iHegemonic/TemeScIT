package org.Tema10;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private int lastCount = 0;

    public FestivalStatisticsThread (FestivalGate gate) {
        this.gate = gate;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Queue<TicketType> queue = gate.getTicketTypeQueue();
            int currentCount = queue.size();

            if (currentCount > lastCount) {
                Map<TicketType, Integer> stats = new HashMap<>();
                for (TicketType ticket : queue) {
                    stats.put(ticket, stats.getOrDefault(ticket, 0) + 1);
                }

                System.out.println("\n==== Festival Statistics ====");
                System.out.println("Total people entered: " + currentCount);
                for (TicketType type : TicketType.values()) {
                    int count = stats.getOrDefault(type, 0);
                    System.out.println(count + " people have " + type.toString().toLowerCase() + " tickets ");
                }
                System.out.println("=============================================================\n");

                lastCount = currentCount;
            }


        }

    }

}
