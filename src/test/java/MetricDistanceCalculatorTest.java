import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.tema6.MetricDistanceCalculator;

public class MetricDistanceCalculatorTest {

  @ParameterizedTest
  @CsvSource({
          "10 cm + 1 m - 10 mm, mm, 1090.0 mm",
          "10 cm + 1 m - 10 mm, mm, 10 mm",
          "10 km + 1km - 2 km, km, 9 km",
  })


    void testComputeExpression(String expression, String outputUnit, String expected) {
    Assertions.assertEquals(expected, MetricDistanceCalculator.computeExpression(expression, outputUnit));
  }

}
