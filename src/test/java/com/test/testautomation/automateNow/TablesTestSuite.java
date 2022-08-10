package com.test.testautomation.automateNow;

import com.test.testautomation.config.WebDriverConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;

public class TablesTestSuite {

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
    public void testTables() {
        //Given & When
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.id("cookie_action_close_header")).click();
        driver.findElement(By.partialLinkText("Tables")).click();

        WebElement dropdown = driver.findElement(By.name("tablepress-1_length"));
        Select ddMenu = new Select(dropdown);
        ddMenu.selectByValue("25");

        driver.findElement(By.xpath("//th[contains(@aria-label,'Country: activate')]")).click();

        WebElement cell = driver.findElement(By.xpath("//tr[23]/td[2]"));

        //Then
        assertEquals("United Kingdom", cell.getText());
    }
}