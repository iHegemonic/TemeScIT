import org.FinalTest1.DeliveryProcessor;
import org.FinalTest1.Package;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class DeliveryProcessorTest {

    @Test
    void processDeliveries_groupsAndProcessesWithoutError() {
        Package pkg1 = new Package(
                "Apahida", 15, 100, LocalDate.of(2017, 9, 1));

        Package pkg2 = new Package(
                "Apahida", 15, 150, LocalDate.of(2017, 9, 1));

        Package pkg3 = new Package(
                "Floresti", 7, 100, LocalDate.of(2017, 9, 2));

        List<Package> packages = List.of(pkg1, pkg2, pkg3);

        DeliveryProcessor processor = new DeliveryProcessor();
        processor.processDeliveries(packages);
    }
}
