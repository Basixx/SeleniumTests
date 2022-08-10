package com.test.testautomation.automateNow;

import com.test.testautomation.config.WebDriverConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTestSuite {

    private static WebDriver driver;
    private static String url;

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
    public void testHoverPositive() {
        //Given & When
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.id("cookie_action_close_header")).click();
        driver.findElement(By.partialLinkText("Hover")).click();

        WebElement hoverElement = driver.findElement(By.id("mouse_over"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        //Then
        assertTrue(driver.getPageSource().contains("You did it!"));
    }
}