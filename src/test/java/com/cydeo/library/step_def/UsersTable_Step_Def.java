package com.cydeo.library.step_def;

import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;


public class UsersTable_Step_Def {
    UsersPage usersPage = new UsersPage();
    @Given("I click on {string} link")
    public void i_click_on_link(String link) {

        BrowserUtils.sleep(5);

       switch (link.toLowerCase()){
           case "dashboard":
               usersPage.dashboardLink.click();
               break;
           case "users":
               usersPage.usersLink.click();
               break;
           case "books":
               usersPage.booksLink.click();
               break;
       }
    }
    @Then("Table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedTableHeader) {

        List<String> actualTableHeader = BrowserUtils.getElementsText(usersPage.elementThead);
        Assert.assertEquals(expectedTableHeader,actualTableHeader);
    }
}
