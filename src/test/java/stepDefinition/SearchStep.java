package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchStep {
    WebDriver driver;
    
    @Before
    public void beforeStep() {
        driver = new ChromeDriver();
    }

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() throws InterruptedException {
       
        driver.get("https://www.google.com");
        Thread.sleep(5000);
    }

    @When("I search for {string}")
    public void i_search_for(String searchString) throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys(searchString);
        Thread.sleep(5000);
        driver.findElement(By.name("btnK")).click();
    }

    @Then("I should see search results")
    public void i_should_see_search_results() throws InterruptedException {
        String expectedTitle = "iPhone";
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        Thread.sleep(5000);
        assert actualTitle.contains(expectedTitle);
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(5000);
        driver.quit();
        
    }
}
