package runner1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature3",
        glue = "stepDefinition1",
        tags="@CartTest",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner3 extends AbstractTestNGCucumberTests 
{

}
