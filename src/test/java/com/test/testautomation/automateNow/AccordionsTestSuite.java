package com.test.testautomation.automateNow;

import com.test.testautomation.config.WebDriverConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccordionsTestSuite {

    private static WebDriver driver;
    private static String url;
    private static String PAGE = "This is an accordion item.";

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
    public void testAccordionsPositive() {
        //Given & When
        driver.get(url);
        driver.findElement(By.id("cookie_action_close_header")).click();
        driver.findElement(By.partialLinkText("Accordions")).click();
        driver.findElement(By.xpath("//summary[@class='wp-block-coblocks-accordion-item__title']")).click();

        //Then
        assertTrue(driver.getPageSource().contains(PAGE));
    }
}