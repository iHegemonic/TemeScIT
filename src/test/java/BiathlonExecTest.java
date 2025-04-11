import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tema7.Athlete;
import org.tema7.BiathlonExec;

import java.time.Duration;
import java.util.List;
public class BiathlonExecTest {

    private BiathlonExec exec;

    @BeforeEach
    public void setUp() {
        exec = new BiathlonExec();
    }


    @Test
    public void testParseCSV() {
        String csvData = "11,Relu Motanelu,RO,30:27,xxxox,xxxxx,xxoxo\n" +
                         "1,Albus Dumbledore,UK,29:15,xxoox,xooxo,xxxxo\n" +
                         "27,Hans Schnitzel,DE,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = exec.parseCSV(csvData);

        Assertions.assertEquals(3, athletes.size());

        Athlete athlete1 = athletes.get(0);
        Assertions.assertEquals(11, athlete1.getNumber());
        Assertions.assertEquals("Relu Motanelu", athlete1.getName());
        Assertions.assertEquals(Duration.ofMinutes(30).plusSeconds(27).plusSeconds(30),
                athlete1.getTotalTime());
    }

    @Test
    public void testGetTop3() {
        String csvData = "11,Relu Motanelu,RO,30:27,xxxox,xxxxx,xxoxo\n" +
                         "1,Albus Dumbledore,UK,29:15,xxoox,xooxo,xxxxo\n" +
                         "27,Hans Schnitzel,DE,30:10,xxxxx,xxxxx,xxxxx";

        List<Athlete> athletes = exec.parseCSV(csvData);
        List<Athlete> top3 = exec.getTop3(athletes);

        Assertions.assertEquals(3, top3.size());
        Assertions.assertEquals("Hans Schnitzel", top3.get(0).getName());
        Assertions.assertEquals("Albus Dumbledore", top3.get(1).getName());
        Assertions.assertEquals("Relu Motanelu", top3.get(2).getName());

    }

}
