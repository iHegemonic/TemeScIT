import org.FinalTest1.PackageLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.FinalTest1.Package;

import java.time.LocalDate;
import java.util.List;

public class PackageLoaderTest {

    @Test
    void loadPackages_validFile_loadsCorrectly() {
        PackageLoader loader = new PackageLoader();
        List<Package> packages = loader.loadPackages("testdata.txt");

        Assertions.assertNotNull(packages);
        Assertions.assertFalse(packages.isEmpty());


        Package pkg = packages.get(0);
        Assertions.assertEquals("Apahida", pkg.getLocation());
        Assertions.assertEquals(15, pkg.getDistance());
        Assertions.assertEquals(100, pkg.getValue());
        Assertions.assertEquals(LocalDate.of(2017, 9, 1), pkg.getDeliveryDate());
    }

}
