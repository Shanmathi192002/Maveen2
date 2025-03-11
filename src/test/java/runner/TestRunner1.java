package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature1",
        glue = "stepDefinition",
         plugin = {"pretty", "json:target/cucumber.json"}
)
public class TestRunner1 extends AbstractTestNGCucumberTests 
{

}
