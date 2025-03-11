package runner9;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature9",
        glue = {"stepDefinition9"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner9 extends AbstractTestNGCucumberTests 
{

}
