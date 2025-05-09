package org.Tema10;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {

    private final Queue<TicketType> ticketTypeQueue = new ConcurrentLinkedQueue<>();

    public void addTicket(TicketType ticket) {
        ticketTypeQueue.add(ticket);
    }

    public Queue<TicketType> getTicketTypeQueue() {
        return ticketTypeQueue;
    }

}
