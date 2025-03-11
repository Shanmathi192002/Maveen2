package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature1",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner1 extends AbstractTestNGCucumberTests 
{

}
