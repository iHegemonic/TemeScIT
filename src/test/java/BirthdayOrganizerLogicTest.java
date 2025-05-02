import org.Tema9.BirthdayData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthdayOrganizerLogicTest {

    public BirthdayOrganizerLogicTest() {
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Test
    void testOrganizeAndSortMarchBirthdays() {
        List<BirthdayData> data = List.of(
                new BirthdayData("Ion", "Johnut", LocalDate.parse("15-03-2000", FORMATTER)),
                new BirthdayData("Maria", "Onat", LocalDate.parse("12-03-2001", FORMATTER)),
                new BirthdayData("Relu", "Castravete", LocalDate.parse("11-03-1999", FORMATTER)),
                new BirthdayData("Marius", "Popescu", LocalDate.parse("01-03-1992", FORMATTER)));

        List <BirthdayData> result = data.stream()
                .filter(d -> d.getDateOfBirth().getMonthValue() == 3)
                .sorted(Comparator.comparing(BirthdayData::getFirstName)
                        .thenComparing(BirthdayData::getLastName))
                .collect(Collectors.toList());

        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals("Ion", result.get(0).getFirstName());
        Assertions.assertEquals("Maria", result.get(1).getFirstName());
        Assertions.assertEquals("Marius", result.get(2).getFirstName());
        Assertions.assertEquals("Relu", result.get(3).getFirstName());
    }


    @Test
    void testNoBirthdaysInTargetMonth() {
        List<BirthdayData> data = List.of(
                new BirthdayData("Alice", "Wonder", LocalDate.parse("15-02-2000", FORMATTER)),
                new BirthdayData("Gicu", "Sandu", LocalDate.parse("11-01-2000", FORMATTER)));


        List<BirthdayData> result = data.stream()
                .filter(r -> r.getDateOfBirth().getMonthValue() == 3)
                .collect(Collectors.toList());

        Assertions.assertTrue(result.isEmpty());
    }

}
