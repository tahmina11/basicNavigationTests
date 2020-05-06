package com.cbt.tests.hmwr2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        runTest("chrome");
        runTest("firefox");
        runTest("safari");


    }

    public static void runTest(String browsetype) {
        WebDriver driver = BrowserFactory.getDriver(browsetype);
        driver.get("https://google.com");
        String googleExpectedTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyExpectedTtile = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(googleExpectedTitle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(etsyExpectedTtile, driver.getTitle());
        driver.quit();

    }
}
