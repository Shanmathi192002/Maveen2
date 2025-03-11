package stepDefinition1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStep {
	private WebDriver driver;

    @Before
    public void beforeStep() {
        driver = new ChromeDriver();
    }

    @Given("I am on the Saucedemo homepage")
    public void i_am_on_the_saucedemo_homepage() throws InterruptedException {
    	Thread.sleep(5000);
        driver.get("https://www.saucedemo.com");
        Thread.sleep(5000);
    }

    @And("I login with valid credentials")
    public void i_login_with_valid_credentials() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(5000);
    }

    @Then("I should see the product in the cart")
    public void i_should_see_the_product_in_the_cart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(5000);
        String expectedText = "Sauce Labs Backpack";
        String actualText = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        assert actualText.contains(expectedText);
    }

    @After
    public void after() throws InterruptedException{
    	Thread.sleep(5000);
    	driver.quit();
    }
    
}
