package com.cbt.tests.hmwr4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.ListConverter;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Olympics {
    WebDriver driver = BrowserFactory.getDriver("chrome");
    WebDriverWait wait;

    @AfterMethod
    public void quit() {
        driver.quit();
    }


    @Test
    public void defaultSortTest() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < list.size() - 2; i++) {
            nums.add(list.get(i).getText());
        }
        System.out.println("nums.toString() = " + nums.toString());
        Assert.assertEquals(nums.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");

        driver.findElement(By.xpath("//th[@class='headerSort'][text()='NOC']")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th[1]"));
        System.out.println(ListConverter.convertElements(countries).toString());
        boolean countriesIsSorted = Ordering.natural().isOrdered(ListConverter.convertElements(countries));
        Assert.assertTrue(countriesIsSorted);
        list = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1]"));
       nums.clear();
        for (int i = 0; i < list.size() - 2; i++) {
            nums.add(list.get(i).getText());
        }
        System.out.println("nums.toString() = " + nums.toString());
        Assert.assertNotEquals(nums.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");


    }


}
