package runner4;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature4",
        glue = {"stepDefinition4"},
        tags = "@CheckoutTest",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner4 extends AbstractTestNGCucumberTests 
{

}
