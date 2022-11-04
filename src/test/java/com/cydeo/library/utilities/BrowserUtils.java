package com.cydeo.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type

    // TC : Create utility method
    // 1. Create a new class BrowserUtils
    // 2. Create a method to make Multiple Windows logic re-usable
    // 3. When method is called, it should switch window title

    /** Method info:
     * Name: switchWindowAndVerify
     * Return type: void
     * Arg1: WebDriver
     * Arg2: String expectedInUrl
     * Arg3: String expectedTitle
     */

    public static void switchWindowAndVerify(String expectedUrl,String expectedTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowHandles){
            Driver.getDriver().switchTo().window(eachWindow);  // syntax will switch each windows and driver will be able to
           // System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        // 5. Assert: Title contains "Etsy"
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue("Title verification failed",actualTitle.contains(expectedTitle));
    }




    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowsersUtils.sleep(3)
     * @param seconds
     */


    public static void sleep(int seconds){

        // 1 second = 1000 millis
        // millis = seconds * 1000

        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }


//    Method info:
//            • Name: verifyTitle()
//            • Return type: void
//            • Arg1: WebDriver
//            • Arg2: String expectedTitle

    public static void verifyTitle_assertEquals(String expectedTitle){

      //  String actualTitle = driver.getTitle();
        Assert.assertEquals("Title verification failed",expectedTitle,Driver.getDriver().getTitle());
    }

    public static void verifyTitle_assertTrue(String expectedTitle){

        //  String actualTitle = driver.getTitle();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }


    public static void waitForInvisibilityOf(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method will accept dropdown as a WebElement
     * and return all the options text in a List of String
     * @return List<String>
     */
    public static List<String> dropDownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);

        // List of all ACTUAL month <options> as a WebElement
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        // List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();
        // f with using for loop we will convert each WebElement of options to String with using getText() method
        // with using add() method we will add each String option in List<String> actual options as a String
        for (WebElement each : actualOptionsAsWebElement){
            actualOptionsAsString.add(each.getText());

        }
        return actualOptionsAsString;

    }

    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * it will loop through the List, and click to the radio button with provided attribute value
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons ) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }

    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     */

    public static List<String> getElementsText(By locator){
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems){
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }
}
