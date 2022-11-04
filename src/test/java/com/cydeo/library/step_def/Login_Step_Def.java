package com.cydeo.library.step_def;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Step_Def {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));

    @Given("I am on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("env"));
    }
    @When("I login as librarian")
    public void user_enters_as_librarian() {
        loginPage.login(ConfigReader.getProperty("lib1_user"),ConfigReader.getProperty("lib1_password"));
    }
    @Then("Dashboard should be displayed")
    public void user_should_see_the_dashboard() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        // BrowserUtils.sleep(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }


    @When("I login as a student")
    public void i_login_as_a_student() {
       loginPage.login(ConfigReader.getProperty("student1_user"),ConfigReader.getProperty("student1_password"));
    }
    @Then("books should be displayed")
    public void books_should_be_displayed() {
        wait.until(ExpectedConditions.urlContains("books"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));
    }
}



