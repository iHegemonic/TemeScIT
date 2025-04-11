package org.tema7;

import java.time.Duration;
import java.util.*;

public class BiathlonExec {

    public List<Athlete> parseCSV(String csvData) {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(csvData);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();

        List<Athlete> athletes = new ArrayList<>();

        for (String line : lines) {
            List<String> parts = Arrays.asList(line.split(","));

            int number = Integer.parseInt(parts.get(0));
            String name = parts.get(1);
            String countryCode = parts.get(2);
            String timeString = parts.get(3).trim();
            Duration skiTime = parseTime(timeString);


            List<ShootingRange> ranges = new ArrayList<>();
            for (int i = 4; i <= 6; i++) {
                ShootingRange range = new ShootingRange(parts.get(i));
                ranges.add(range);
            }


            Athlete athlete = new Athlete(number, name, countryCode, skiTime, ranges);
            athletes.add(athlete);
        }
        return athletes;
    }

    private Duration parseTime(String timeString) {
        List<String> parts = Arrays.asList(timeString.split(":"));
        int minutes = Integer.parseInt(parts.get(0));
        int seconds = Integer.parseInt(parts.get(1));
        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }


    public List<Athlete> getTop3(List<Athlete> athletes) {
        Collections.sort(athletes);

        List<Athlete> top3 = new ArrayList<>();
        for(int i = 0; i < 3 && i < athletes.size(); i++) {
            top3.add(athletes.get(i));
        }


        return top3;
    }



}
