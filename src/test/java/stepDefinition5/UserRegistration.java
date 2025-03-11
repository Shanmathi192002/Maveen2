package stepDefinition5;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistration {
    WebDriver driver;

    @Before
    public void beforeAll() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        Thread.sleep(5000);
    }

    @Given("I am on the Demoblaze signup page")
    public void i_am_on_the_demoblaze_signup_page() {
        // No need to implement this step as it's already implemented in the @BeforeAll method
    }

    @When("I enter valid registration details")
    public void i_enter_valid_registration_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    	driver.findElement(By.id("signin2")).click();
    	Thread.sleep(5000);
        dataTable.asMaps().forEach(row -> {
            driver.findElement(By.id("sign-username")).sendKeys(row.get("username"));
            driver.findElement(By.id("sign-password")).sendKeys(row.get("password"));
        });
        Thread.sleep(5000);
    }

    @And("I click on the signup button")
    public void i_click_on_the_signup_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);
    }
   
//    @And("I click on the OK button")
//    public void i_click_on_the_ok_button() {
//        driver.findElement(By.xpath("//button[@class='confirm btn btn-primary btn-sm']")).click();
//    }

    @After
    public void afterAll() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.quit();
    }
}
