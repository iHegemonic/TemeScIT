import org.Tema10.FestivalGate;
import org.Tema10.TicketType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Queue;

public class FestivalGateTest {

    @Test
    public void testAddAndRetrieveTicket() {
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.FREE_PASS);

        Queue<TicketType> queue = gate.getTicketTypeQueue();
        Assertions.assertEquals(2, queue.size());
        Assertions.assertTrue(queue.contains(TicketType.FULL));
        Assertions.assertTrue(queue.contains(TicketType.FREE_PASS));
    }


    @Test

    public void testTicketQueueIsThreadSafe() {
        FestivalGate gate = new FestivalGate();
        for (int i = 0; i < 100; i++) {
            gate.addTicket(TicketType.FULL);
        }
        Assertions.assertEquals(100, gate.getTicketTypeQueue().size());
    }

}
