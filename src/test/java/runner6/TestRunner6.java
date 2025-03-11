package runner6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature6",
        glue = "stepDefinition6",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner6 extends AbstractTestNGCucumberTests 
{

}
