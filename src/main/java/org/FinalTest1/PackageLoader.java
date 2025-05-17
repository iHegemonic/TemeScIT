package org.FinalTest1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PackageLoader {

    public List <Package> loadPackages(String filename) {
        List<Package> packages = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().
                getClassLoader().getResourceAsStream(filename)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String location = parts[0];
                int distance = Integer.parseInt(parts[1]);
                double value = Double.parseDouble(parts[2]);
                LocalDate date = LocalDate.parse(parts[3]);

                packages.add(new Package(location, distance, value, date));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return packages;
    }
}
