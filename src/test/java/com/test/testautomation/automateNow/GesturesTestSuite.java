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

public class GesturesTestSuite {

    private static WebDriver driver;
    private static String url;

    @BeforeAll
    private static void prepare() {
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
        driver.manage().window().maximize();
        driver.findElement(By.id("cookie_action_close_header")).click();
        driver.findElement(By.partialLinkText("Gestures")).click();

        WebElement map = driver.findElement(By.xpath("//canvas"));
        Actions moveMap = new Actions(driver);

        ElementsWait.waitForElement(driver, map);
        WebElement fullScreen = driver.findElement(By.xpath("(//button[@class = 'mapboxgl-ctrl-fullscreen'])[1]"));
        fullScreen.click();

        for(int i = 0; i < 5; i++){
            driver.findElement(By.xpath("(//span[@class = 'mapboxgl-ctrl-icon'])[2]")).click();
        }

        moveMap.moveToElement(map, 0, 0).clickAndHold()
                .moveByOffset(1000, 50).release().build().perform();

        fullScreen.click();

        //Then
        assertTrue(driver.getPageSource().contains("user gestures"));
    }
}