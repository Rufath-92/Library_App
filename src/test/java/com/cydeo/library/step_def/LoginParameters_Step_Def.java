package com.cydeo.library.step_def;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginParameters_Step_Def {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    @When("I enter username {string}")
    public void i_enter_username(String userName) {
        loginPage.userNameBox.sendKeys(userName);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordBox.sendKeys(password);
    }
    @When("Click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInBtn.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
    }
    @Then("There should be {string} users")
    public void there_should_be_users(String expectedUserCount) {
      Assert.assertEquals(expectedUserCount,landingPage.userCount.getText());
    }
}

