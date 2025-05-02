package org.Tema9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BirthdayOrganizer {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final DateTimeFormatter toMonthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);

    private BirthdayData parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid line: " + line);
        }
        String firstName = parts[0];
        String lastName = parts[1];
        LocalDate dateOfBirth = LocalDate.parse(parts[2], FORMATTER);
        return new BirthdayData(firstName, lastName, dateOfBirth);

    }

    public List<BirthdayData> readFromFile(String inputFile) throws IOException {
        return Files.readAllLines(Path.of(inputFile)).stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    public List<BirthdayData> filterByMonth(List<BirthdayData> PiecesOfData, int targetMonth) {
        return PiecesOfData.stream()
                .filter(data -> data.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted((r1, r2) -> {
                    int firstNameCompare = r1.getFirstName().compareToIgnoreCase(r2.getFirstName());
                    if (firstNameCompare != 0) {
                        return firstNameCompare;
                    }

                    return r1.getLastName().compareToIgnoreCase(r2.getLastName());
                })
                .collect(Collectors.toList());
    }

    public void writeToFile(String filename, List<BirthdayData> data) throws IOException {
        List<String> lines = data.stream()
                .map(d -> d.getFirstName() + " " + d.getLastName() + " born in " +
                        d.getDateOfBirth().format(toMonthFormatter) + " " + d.getDateOfBirth().getYear())
                .toList();
        Files.write(Path.of(filename), lines);
    }


}
