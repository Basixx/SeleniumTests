package com.test.testautomation.simple.facebook;

import com.test.testautomation.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTest {
    public static final String XPATH_COOKIES = "//*[@data-cookiebanner=\"accept_only_essential_button\"]";
    public static final String XPATH_CREATE_ACCOUNT = "//*[@data-testid=\"open-registration-form-button\"]";
    public static final String XPATH_FIRSTNAME = "//*[contains(@name, \"firstname\")]";
    public static final String XPATH_LASTNAME = "//*[contains(@name, \"lastname\")]";
    public static final String XPATH_BIRTHDAY_DAY = "//select[contains(@name, \"birthday_day\")]";
    public static final String XPATH_BIRTHDAY_MONTH = "//select[contains(@name, \"birthday_month\")]";
    public static final String XPATH_BIRTHDAY_YEAR = "//select[contains(@name, \"birthday_year\")]";
    public static final String XPATH_SEX = "//*[@name=\"sex\" and @value=\"1\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://pl-pl.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        WebElement firstName = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstName.sendKeys("Barbara");
        WebElement lastName = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastName.sendKeys("Rutkowska");

        WebElement birthdayDay = driver.findElement(By.xpath(XPATH_BIRTHDAY_DAY));
        WebElement birthdayMonth = driver.findElement(By.xpath(XPATH_BIRTHDAY_MONTH));
        WebElement birthdayYear = driver.findElement(By.xpath(XPATH_BIRTHDAY_YEAR));

        while (!birthdayDay.isDisplayed());

        Select selectDay = new Select(birthdayDay);
        selectDay.selectByIndex(21);

        Select selectMonth = new Select(birthdayMonth);
        selectMonth.selectByIndex(1);

        Select selectYear = new Select(birthdayYear);
        selectYear.selectByValue("1998");

        driver.findElement(By.xpath(XPATH_SEX)).click();
    }
}
