import org.FinalTest1.DeliveryGroup;
import org.FinalTest1.Package;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class DeliveryGroupTest {

    @Test
    void getGroupValue_andGetRevenue_workCorrectly() {
        Package pkg1 = new Package(
                "Apahida", 15, 100, LocalDate.of(2017, 9, 1));
        Package pkg2 = new Package(
                "Apahida", 15, 150, LocalDate.of(2017, 9, 1));

        List<Package> packages = List.of(pkg1, pkg2);

        DeliveryGroup group = new DeliveryGroup(
                "Apahida", LocalDate.of(2017, 9, 1), packages);

        Assertions.assertEquals(250, group.getGroupValue(), 0.001);
        Assertions.assertEquals(15, group.getRevenue(), 0.001);

    }
}
