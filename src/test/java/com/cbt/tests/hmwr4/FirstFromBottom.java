package com.cbt.tests.hmwr4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstFromBottom {
    WebDriver driver;
    WebDriverWait wait;

    @AfterMethod
    public void beforeMethod(){
        driver.quit();
    }
    @Test
    public void firstFromTheBottom(){

    }
}
