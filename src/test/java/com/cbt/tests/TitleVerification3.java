package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com",
                "https://www.westelm.com",
                "https://walmart.com)");


       startAgain(urls.get(0));
       startAgain(urls.get(1));
       startAgain(urls.get(2));
       startAgain(urls.get(3));

    }

    public static void startAgain(String urls) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        Thread.sleep(2000);
        driver.get(urls);
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        title = title.replaceAll(" ", "").toLowerCase();
        driver.quit();
        if (url.contains(title)) {
            System.out.println("Pass");

        } else {
            System.out.println("Fail");

        }
        driver.quit();

    }
}
