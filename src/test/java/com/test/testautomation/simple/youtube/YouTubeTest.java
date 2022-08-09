package com.test.testautomation.simple.youtube;

import com.test.testautomation.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class YouTubeTest {
    public static final String SEARCHFIELD = "search_query";
    public static final String COOKIES = "//div[contains(@class, \"eom-buttons\")]/div/ytd-button-renderer[1]/a/tp-yt-paper-button[contains(@aria-label,\"zgody\")]";

    public static final String SONG = "//yt-formatted-string[contains(@aria-label, \"Never Gonna Give You Up\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

        assert driver != null;


        driver.get("https://www.youtube.com/");
        waitToLoad();

        driver.findElement(By.xpath(COOKIES)).click();

        waitToLoad();
        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("never gonna give you up");
        searchField.submit();

        waitToLoad();

        WebElement song = driver.findElement(By.xpath(SONG));
        song.click();
    }

    private static void waitToLoad() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


