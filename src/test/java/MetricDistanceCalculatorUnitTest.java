import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tema6.MetricDistanceCalculator;

public class MetricDistanceCalculatorUnitTest {

    @Test
    void testAddition(){
        String result = MetricDistanceCalculator.computeExpression("2 m + 500 cm", "m");
        Assertions.assertEquals("7.0 m", result);
    }

    @Test
    void testSubraction() {
        String result = MetricDistanceCalculator.computeExpression("1 km - 500 m", "m");
        Assertions.assertEquals("500.0 m", result);
    }

    @Test
    void testMultipleOperations() {
        String result = MetricDistanceCalculator.computeExpression("1 km + 500 m - 200 m","km");
        Assertions.assertEquals("1.3 km", result);
    }

    @Test
    void testInvalidOperator() {
        String result = MetricDistanceCalculator.computeExpression("1 m * 2 km", "km");
        Assertions.assertEquals("Invalid operator: *", result);
    }

    @Test
    void testUnsupportedUnit() {
        String result = MetricDistanceCalculator.computeExpression("1 ml + 2 KM", "km");
        Assertions.assertEquals(0.0 + " km", result);
    }


}
