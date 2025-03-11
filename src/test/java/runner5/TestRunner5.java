package runner5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature5",
        glue = {"stepDefinition5"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner5 extends AbstractTestNGCucumberTests 
{

}
