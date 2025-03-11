package stepDefinition9;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {
    WebDriver driver;

    @Given("I am logged in to Demoblaze")
    public void i_am_logged_in_to_demoblaze() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.findElement(By.id("login2")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("loginusername")).sendKeys("mathi");
        Thread.sleep(3000);
        driver.findElement(By.id("loginpassword")).sendKeys("24379");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
    }

    @When("I add the product {string} to the wishlist")
    public void i_add_the_product_to_the_wishlist(String productName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        Thread.sleep(3000);
    }

    @Then("I should see the product in the wishlist")
    public void i_should_see_the_product_in_the_wishlist() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
        Thread.sleep(3000);
        String actualProductName = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText();
        Thread.sleep(3000);
        assert actualProductName.contains("Samsung galaxy s6");
    }
}

