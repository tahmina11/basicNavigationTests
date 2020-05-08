package com.cbt.tests.hmwr4;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.ListConverter;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstFromBottom {
    WebDriver driver = BrowserFactory.getDriver("chrome");
    WebDriverWait wait;


    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void firstFromTheBottom() {
        Assert.assertTrue(countryWithSmallestGoldMedals().contains("Italy"));
        Assert.assertTrue(countryWithSmallestSilverMedals().contains("South Korea"));
        Assert.assertTrue(countryWithSmallestBronzeMedals().contains("Italy"));
        System.out.println(countryByMedalSilver());
        System.out.println(Arrays.toString(getIndexOfCountry("Russia")));
        System.out.println(getSumBronze().toString());
    }


    public String countryWithSmallestBronzeMedals() {
        driver.findElement(By.xpath("//th[@class='headerSort'][text()='Bronze']")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4]"));
        List<String> strCountries = ListConverter.convertElements(countries);
        String country = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th")).getText();
        System.out.println("country = " + country);
        return country;

    }

    public String countryWithSmallestSilverMedals() {
        driver.findElement(By.xpath("//th[@class='headerSort'][text()='Silver']")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));
        List<String> strCountries = ListConverter.convertElements(countries);
        String country = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th")).getText();
        System.out.println("country = " + country);
        return country;

    }


    public String countryWithSmallestGoldMedals() {

        driver.findElement(By.xpath("//th[@class='headerSort'][text()='Gold']")).click();
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2]"));
        List<String> strCountries = ListConverter.convertElements(countries);
        String country = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th")).getText();
        System.out.println("country = " + country);
        return country;

    }

    public List<String> countryByMedalSilver() {
        List<String> all = new ArrayList<>();
        List<WebElement> countNum = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3]"));
        List<String> numCountries = ListConverter.convertElements(countNum);
        System.out.println(numCountries.toString());
        List<WebElement> countries = driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th"));
        List<String> listCountries = ListConverter.convertElements(countries);
        for (int i = 0; i < listCountries.size(); i++) {
            all.add(listCountries.get(i) + " " + numCountries.get(i));
        }
        return all;
    }

    public int[] getIndexOfCountry(String country) {
        int[] indexes = new int[2];
        driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a[text()='" + country + "']"));
        String num = driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a[text()='" + country + "']/../../td")).getText();
        System.out.println("num = " + num);
        indexes[0] = Integer.parseInt(num);
        indexes[1] = 2;
        return indexes;

    }
    public List<String> getSumBronze(){
        List<String> all= new ArrayList<>();
        String italy=  driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a[text()='Italy']")).getText();
        String austalia= driver.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a[text()='Australia']")).getText();
        all.add(italy);
        all.add(austalia);
        return all;
    }

}
