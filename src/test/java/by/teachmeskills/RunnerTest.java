package by.teachmeskills;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "by/teachmeskills/steps")
public class RunnerTest extends AbstractTestNGCucumberTests {
}
