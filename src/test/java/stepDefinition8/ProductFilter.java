package stepDefinition8;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductFilter {
    WebDriver driver;

    @BeforeStep
    public void beforeStep() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        Thread.sleep(5000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Given("I am logged in to Saucedemo")
    public void i_am_logged_in_to_saucedemo() {
        // No need to implement this step as it's already implemented in the @BeforeStep method
    }

    @When("I select the filter option {string}")
    public void i_select_the_filter_option(String filterOption) throws InterruptedException {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[text()='" + filterOption + "']")).click();
        Thread.sleep(5000);
    }

    @Then("I should see the filtered products")
    public void i_should_see_the_filtered_products() throws InterruptedException {
        assert driver.findElement(By.xpath("//div[@class='inventory_list']")).isDisplayed();
        Thread.sleep(5000);
    }

    @AfterStep
    public void afterStep() throws InterruptedException {
    	Thread.sleep(5000);
        driver.quit();
    }
}
