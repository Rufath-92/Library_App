package com.cydeo.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "inputEmail")
    public WebElement userNameBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    public void login(String userName,String password){
        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);
        signInBtn.click();
    }
}
