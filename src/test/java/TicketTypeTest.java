import org.Tema10.TicketType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TicketTypeTest {

    @Test
    public void TestAllTicketTypesExist() {
        List<TicketType> types = Arrays.stream(TicketType.values()).toList();
        Assertions.assertEquals(5, types.size());

        Assertions.assertNotNull(TicketType.FULL);
        Assertions.assertNotNull(TicketType.FULL_VIP);
        Assertions.assertNotNull(TicketType.FREE_PASS);
        Assertions.assertNotNull(TicketType.ONE_DAY);
        Assertions.assertNotNull(TicketType.ONE_DAY_VIP);
    }

}
