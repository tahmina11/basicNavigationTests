package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com",
                "https://www.westelm.com",
                "https://walmart.com)");
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        Thread.sleep(2000);
        String title = driver.getTitle();
       String url= driver.getCurrentUrl();

       verifyContains(title, url);

        driver.get(urls.get(1));
        Thread.sleep(2000);
      title = driver.getTitle();
        url= driver.getCurrentUrl();
        verifyContains(title, url);

        driver.get(urls.get(2));
        Thread.sleep(2000);
        title = driver.getTitle();
        url= driver.getCurrentUrl();
        verifyContains(title, url);

        driver.get(urls.get(3));
        Thread.sleep(2000);
        title = driver.getTitle();

        url= driver.getCurrentUrl();
        verifyContains(title, url);

        driver.quit();


    }
    public static void verifyContains(String title, String url){
        title = title.replaceAll(" ","").toLowerCase();
        if (url.contains(title)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
