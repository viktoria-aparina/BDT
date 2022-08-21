package by.teachmeskills;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featuresForBooking", glue = "by/teachmeskills/booking/steps")
public class RunnerTest extends AbstractTestNGCucumberTests {
}
