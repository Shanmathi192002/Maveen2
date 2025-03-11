package stepDefinition4;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStep {
    private WebDriver driver;

    @Before
    public void beforeStep() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    @Given("I am on the Saucedemo homepage")
    public void i_am_on_the_saucedemo_homepage() {
        // No need to implement this step as it's already implemented in the @Before method
    }

   
    @And("I login with valid credentials")
    public void i_login_with_valid_credentials() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(5000);
    }

    @And("I click on the shopping cart link")
    public void i_click_on_the_shopping_cart_link() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        Thread.sleep(5000);
    }

    @And("I click on the checkout button")
    public void i_click_on_the_checkout_button() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(5000);
    }

    @When("I enter my personal details")
    public void i_enter_my_personal_details(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            driver.findElement(By.id("first-name")).sendKeys(row.get("firstName"));
            driver.findElement(By.id("last-name")).sendKeys(row.get("lastName"));
            driver.findElement(By.id("postal-code")).sendKeys(row.get("postalCode"));
        });
    }

    @And("I click on the continue button")
    public void i_click_on_the_continue_button() {
        driver.findElement(By.id("continue")).click();
    }
    
    @And("I click on the finish button")
    public void i_click_on_the_finish_button() {
        driver.findElement(By.id("finish")).click();
    }
    
    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {
        String expectedMessage = "thank you for your order";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText().toLowerCase();
        assert actualMessage.contains(expectedMessage);
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}

