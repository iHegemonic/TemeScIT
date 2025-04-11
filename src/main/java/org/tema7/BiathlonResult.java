package org.tema7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BiathlonResult {

    public void run(String filePath) {
        BiathlonExec executable = new BiathlonExec();

        try {
            String csvData = Files.readString(Paths.get(filePath));


            List<Athlete> athletes = executable.parseCSV(csvData);

            List<Athlete> top3 = executable.getTop3(athletes);

            System.out.println("Final results:");
            System.out.println("Winner - " + top3.get(0));
            System.out.println("Runner-up - " + top3.get(1));
            System.out.println("Third Place - " + top3.get(2));

        } catch(IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough athletes to create a top 3 list.");
        }
    }
}
