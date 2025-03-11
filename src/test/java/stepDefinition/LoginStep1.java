package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep1 {
    WebDriver driver;

    @Before
    public void setup() {
        
        driver = new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(5000);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        Thread.sleep(5000);
    }

    @Then("I should see a successful login message")
    public void i_should_see_a_successful_login_message() throws InterruptedException {
        String expectedMessage = "You logged into a secure area!";
        Thread.sleep(5000);
        String actualMessage = driver.findElement(By.cssSelector("#flash")).getText();
        Thread.sleep(5000);
        assert actualMessage.contains(expectedMessage);
    }


    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.quit();
        
    }
}
