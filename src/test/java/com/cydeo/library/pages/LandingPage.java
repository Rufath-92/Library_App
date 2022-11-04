package com.cydeo.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(id = "user_count")
    public WebElement userCount;
}
