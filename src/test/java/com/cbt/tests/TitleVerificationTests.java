package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.List;


public class TitleVerificationTests {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        String actual1 = driver.getTitle();
        String title1 = driver.getCurrentUrl();
        driver.get(urls.get(1));
        String actual2 = driver.getTitle();
        String title2 = driver.getCurrentUrl();
        driver.get(urls.get(2));
        String actual3 = driver.getTitle();
        String title3 = driver.getCurrentUrl();
        if (actual1.equals(actual2) && actual1.equals(actual3)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        String expectedTitle = "http://practice.cybertekschool.com";
        if (title1.startsWith(expectedTitle
        ) && title2.startsWith(expectedTitle)
                && title3.startsWith(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        driver.quit();

    }
}
