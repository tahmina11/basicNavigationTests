package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class locators_hmwr {
    WebDriver driver = BrowserFactory.getDriver("chrome");
    WebDriverWait wait;

    @AfterMethod
    public void afterMethod() {
         driver.quit();
    }

    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        String actual = "wooden spoon";
        Assert.assertTrue(driver.getTitle().contains(actual));

    }

    @Test
    public void wikiTest() {
        driver.get("https://www.wikipedia.org/");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("Selenium_(software)"));

    }

    @Test
    public void googleTest() throws InterruptedException {
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<String> searchStrs = Arrays.asList("Java", "cucumber bdd", "Selenium web browser automation");
        for (String each : searchStrs) {
            WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            search.sendKeys(each + Keys.ENTER);
            Thread.sleep(3000);
            String url = driver.findElement(By.xpath("//div[@class='TbwUpd NJjxre']/cite")).getText();

            driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();
            System.out.println(driver.getCurrentUrl());
            System.out.println("url = " + url);
            Assert.assertTrue(driver.getCurrentUrl().contains(url));

            driver.navigate().back();
            search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            search.clear();


        }

    }

    @Test
    public void ebayTest() {
        driver.get("https://ebay.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement search = driver.findElement(By.id("gh-ac"));
        search.sendKeys("wooden spoon" + Keys.ENTER);
        String num = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span")).getText();
        driver.findElement(By.linkText("All")).click();
        String after = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span")).getText();

        num = num.replaceAll(",", "");
        after = after.replaceAll(",", "");
        int num1 = Integer.parseInt(num);
        int after1 = Integer.parseInt(after);
        Assert.assertTrue(num1 < after1);

        driver.navigate().back();
        search = driver.findElement(By.id("gh-ac"));
        String woodenSpoon = search.getAttribute("value");
        System.out.println("saw = " + woodenSpoon);
        Assert.assertEquals(woodenSpoon, "wooden spoon");

        driver.navigate().back();
        search = driver.findElement(By.id("gh-ac"));
        Assert.assertTrue(search.getAttribute("value").isEmpty());

    }
    @Test
    public void vytrackTitleTest() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager107");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123"+Keys.ENTER);
        Thread.sleep(3000);


        driver.findElement(By.xpath("//li[@class='dropdown user-menu-dropdown']/a")).click();
        driver.findElement(By.linkText("My Configuration")).click();

        String name =  driver.findElement(By.xpath("//li[@class='dropdown user-menu-dropdown']/a")).getText();
        Assert.assertTrue(driver.getTitle().startsWith(""));

    }
    @Test
    public void VytrackShortcutFunctionalitTest() throws InterruptedException {
        driver.get("http://qa1.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager107");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123"+Keys.ENTER);
       assertEquals(driver.getTitle(), "Dashboard");

       wait = new WebDriverWait(driver, 10);

       Thread.sleep(2000);
       WebElement iconShort = driver.findElement(By.xpath("//div[@class='nav top-search shortcuts']"));
       iconShort.click();


       WebElement allList = driver.findElement(By.linkText("See full list"));
       allList.click();
       driver.findElement(By.linkText("Opportunities")).click();
       Thread.sleep(3000);
       assertTrue(driver.getTitle().startsWith("Open Opportunities"));
        iconShort.click();
        allList.click();
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        String message = driver.findElement(By.xpath("//div[@class='message']")).getText();
        assertEquals(message, "You do not have permission to perform this action.");
        assertTrue(driver.getTitle().equals("Shortcut Actions List"));



    }

}
