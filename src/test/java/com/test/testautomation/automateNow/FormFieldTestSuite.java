package com.test.testautomation.automateNow;

import com.test.testautomation.config.WebDriverConfig;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class FormFieldTestSuite {

    private static WebDriver driver;
    private static String url;

    private static final String INPUT = "hello it is me Mario";
    private static final String EMAIL = "email@email.com";
    private static final String MESSAGE = "Hi, my name is Barbara. It is nice to meet you. Best Regards!";

    @BeforeAll
    private static void prepare(){
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        url = "https://automatenow.io/sandbox-automation-testing-practice-website/";
    }

    @AfterAll
    private static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void testFormPositive() {
        //Given & When

        driver.get(url);
        driver.findElement(By.id("cookie_action_close_header")).click();
        driver.findElement(By.partialLinkText("Form Fields")).click();

        WebElement input1 = driver.findElement(By.id("g1103-inputfield"));
        input1.clear();
        input1.sendKeys(INPUT);

        driver.findElement(By.xpath("//input[@value='Option 1']")).click();
        driver.findElement(By.xpath("//input[@value='Option 2']")).click();

        driver.findElement(By.xpath("(//input[@value='Blue'])[1]")).click();

        WebElement dropdown = driver.findElement(By.id("g1103-dropdownmenu"));
        Select ddMenu = new Select(dropdown);
        ddMenu.selectByIndex(3);

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(EMAIL);

        WebElement inputBox = driver.findElement(By.id("contact-form-comment-message"));
        inputBox.sendKeys(MESSAGE);

        WebElement submit = driver.findElement(By.xpath("(//p[@class=\"contact-submit\"]/button[@type= 'submit'])[1]"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", submit);
        waitForElement(submit);
        submit.click();

        //Then
        assertTrue(driver.getPageSource().contains(INPUT));
        assertTrue(driver.getPageSource().contains("Option 1"));
        assertTrue(driver.getPageSource().contains("Option 2"));
        assertTrue(driver.getPageSource().contains("Blue"));
        assertTrue(driver.getPageSource().contains("Octal"));
        assertTrue(driver.getPageSource().contains(EMAIL));
        assertTrue(driver.getPageSource().contains(MESSAGE));
    }

    public void waitForElement(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}