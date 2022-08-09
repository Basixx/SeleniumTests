package com.test.testautomation.simple.google;

import com.test.testautomation.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTest {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("stack overflow");
        searchField.submit();
    }
}
