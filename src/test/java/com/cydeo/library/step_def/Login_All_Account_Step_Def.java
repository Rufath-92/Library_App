package com.cydeo.library.step_def;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_All_Account_Step_Def {
        LoginPage loginPage = new LoginPage();

        @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        loginPage.userNameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInBtn.click();

    }
    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedName) {

        BrowserUtils.waitForVisibilityOf(loginPage.usernameLink);
        String actualUserName = loginPage.usernameLink.getText();
        Assert.assertEquals(expectedName,actualUserName);

    }

}
