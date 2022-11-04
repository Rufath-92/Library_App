package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

//public class Driver {
//
//    private Driver() {
//    }
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//
//        if(driver == null){
//            String browserType = ConfigReader.getProperty("browser");
//
//            switch (browserType){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//                case "safari":
//                    WebDriverManager.safaridriver().setup();
//                    driver = new SafariDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//                    break;
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//                case "EDGE":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//                    break;
//            }
//        }
//
//        return driver;
//    }
//
//    public static void closeDriver(){
//        if (driver != null){
//            driver.quit();
//            driver= null;
//        }
//    }
//}


public class Driver {


    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            String browserType = ConfigReader.getProperty("browser");


            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
