import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({MetricDistanceCalculatorTest.class, MetricDistanceCalculatorUnitTest.class})

public class MetricDistanceTestSuite {

}
