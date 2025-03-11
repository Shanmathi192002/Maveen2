package stepDefinition6;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasswordReset {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @Given("the user is on the forgot password page")
    public void user_is_on_forgot_password_page() {
        driver.get("https://the-internet.herokuapp.com/forgot_password");
    }

    @When("the user enters their email address")
    public void user_enters_email_address() throws InterruptedException {
        WebElement emailInput = driver.findElement(By.name("email"));
        Thread.sleep(5000);
        emailInput.sendKeys("shanmathi@gmail.com");
        Thread.sleep(5000);
    }

    @When("the user clicks the {string} button")
    public void user_clicks_retrieve_password_button(String button) throws InterruptedException {
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(5000);
        retrievePasswordButton.click();
    }

    @Then("the user receives a password reset email")
    public void user_receives_password_reset_email() throws InterruptedException {
        // Verify password reset email is sent
        // This step may require additional implementation
        // to verify the email is sent, such as using an email API
        System.out.println("Password reset email sent");
        Thread.sleep(5000);
    }

//    @Given("the user is on the login page")
//    public void user_is_on_login_page() throws InterruptedException {
//        driver.get("https://the-internet.herokuapp.com/login");
//        Thread.sleep(5000);
//    }

//    @When("the user clicks the {string} link")
//    public void user_clicks_forgot_password_link(String link) throws InterruptedException {
//        Thread.sleep(5000);
//        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot password"));
//        forgotPasswordLink.click();
//    }

    @Then("the user is redirected to the forgot password page")
    public void user_is_redirected_to_forgot_password_page() throws InterruptedException {
        String currentPageUrl = driver.getCurrentUrl();
        Thread.sleep(5000);
        if (currentPageUrl.equals("https://the-internet.herokuapp.com/forgot_password")) {
            System.out.println("User is redirected to the forgot password page");
        } else {
            System.out.println("User is not redirected to the forgot password page");
        }
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(5000);
    	driver.quit();
    }
}



