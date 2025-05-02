package org.Tema9;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class BirthdayFilterRunner {

    public Config readConfig(String filePath) throws IOException {
        List <String> lines = Files.readAllLines(Path.of(filePath));
        if (lines.size() < 3) {
            throw new IllegalArgumentException("Config must have 3 lines: input file, targeted month and output file.");
        }

        String inputFile = lines.get(0);
        int month = Integer.parseInt(lines.get(1));
        String outputFile = lines.get(2);

        return new Config(inputFile, month, outputFile);
    }

    public record Config(String inputFile, int targetMonth, String outputFile) {}

    public void run () {
        try {
            Config config = readConfig("Config.txt");

            BirthdayOrganizer organizer = new BirthdayOrganizer();
            List<BirthdayData> data = organizer.readFromFile(config.inputFile());
            List<BirthdayData> filteredSorted = data.stream()
                    .filter(d -> d.getDateOfBirth().getMonthValue() == config.targetMonth())
                    .sorted(Comparator.comparing(BirthdayData::getFirstName)
                    .thenComparing(BirthdayData::getLastName))
                    .toList();

            organizer.writeToFile(config.outputFile(), filteredSorted);
            System.out.println("File written successfully!");

        } catch (Exception e) {
            System.out.println("Oops, error found: " + e.getMessage());
        }
    }


}
