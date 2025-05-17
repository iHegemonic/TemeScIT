package org.FinalTest1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeliveryProcessor {

    public void processDeliveries(List<Package> packages) {
        Map<String, Map<LocalDate, List<Package>>> grouped = new HashMap<>();

        for (Package pkg : packages) {
            grouped
                    .computeIfAbsent(pkg.getLocation(), k -> new HashMap<>())
                    .computeIfAbsent(pkg.getDeliveryDate(), k -> new ArrayList<>())
                    .add(pkg);
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        List<DeliveryGroup> deliveryGroups = new ArrayList<>();

        for (Map.Entry<String, Map<LocalDate, List<Package>>> locationEntry : grouped.entrySet()) {
            for (Map.Entry<LocalDate, List<Package>> dateEntry : locationEntry.getValue().entrySet()) {
                DeliveryGroup group = new DeliveryGroup(locationEntry.getKey(), dateEntry.getKey(), dateEntry.getValue());
                deliveryGroups.add(group);
                executor.submit(group);
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {

        }

        double totalValue = deliveryGroups.stream().mapToDouble(DeliveryGroup::getGroupValue).sum();
        double totalRevenue = deliveryGroups.stream().mapToDouble(DeliveryGroup::getRevenue).sum();


        System.out.println("RESULT: ");
        System.out.printf("Total value of all delivered packages: %.2f LEI%n", totalValue);
        System.out.printf("Total revenue from all groups: %.2f LEI%n", totalRevenue);
    }

}

