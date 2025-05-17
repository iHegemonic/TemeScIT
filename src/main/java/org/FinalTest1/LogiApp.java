package org.FinalTest1;

import java.util.List;

public class LogiApp {

    public static void run(String dataFile) {
        PackageLoader loader = new PackageLoader();
        List<Package> packages = loader.loadPackages("data.txt");

        DeliveryProcessor processor = new DeliveryProcessor();
        processor.processDeliveries(packages);
    }
}
