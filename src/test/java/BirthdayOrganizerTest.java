import org.Tema9.BirthdayData;
import org.Tema9.BirthdayOrganizer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.Mockito.*;

public class BirthdayOrganizerTest {

    public BirthdayOrganizerTest() {
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Test
    void testWriteToFile() throws Exception {
        BirthdayOrganizer organizer = mock(BirthdayOrganizer.class);
        List<BirthdayData> data = List.of(
                new BirthdayData("Ion", "Popescu", LocalDate.parse("12-03-2001", FORMATTER))
        );

        organizer.writeToFile("output.txt", data);

        verify(organizer, times(1)).writeToFile("output.txt", data);
    }
}
