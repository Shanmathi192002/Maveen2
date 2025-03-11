package runner8;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature8",
        glue = {"stepDefinition8"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner8 extends AbstractTestNGCucumberTests 
{

}
