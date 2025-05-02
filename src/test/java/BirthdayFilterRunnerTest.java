import org.Tema9.BirthdayFilterRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class BirthdayFilterRunnerTest {

    public BirthdayFilterRunnerTest() {
    }

    @Test
    public void testReadConfig() throws Exception {
        List<String> mockLines = List.of("input.txt", "2", "output.txt");

        try (MockedStatic<Files> mockedStatic = Mockito.mockStatic(Files.class)) {

            mockedStatic.when(() -> Files.readAllLines(Path.of("config.txt")))
                    .thenReturn(mockLines);

            BirthdayFilterRunner runner = new BirthdayFilterRunner();

            BirthdayFilterRunner.Config config = runner.readConfig("config.txt");

            Assertions.assertEquals("input.txt", config.inputFile());
            Assertions.assertEquals(2, config.targetMonth());
            Assertions.assertEquals("output.txt", config.outputFile());
        }
    }
        }




