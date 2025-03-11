package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature2",
        glue = "stepDefinition",
        tags="@SearchTest",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner2 extends AbstractTestNGCucumberTests 
{

}
