package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class WaitsTest extends BaseTest {

    @Test
    public void presenceOfElementTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();
        Assert.assertFalse(button.isDisplayed());

        WebElement loading = driver.findElement(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Thread.sleep(7000);
        Assert.assertFalse(loading.isDisplayed());

        Assert.assertTrue(driver.findElement(By.cssSelector("#finish h4")).isDisplayed());
    }


    @Test
    public void presenceOfElementTest1() {
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(15));

        WebElement button = wait.waitForVisibilityBy(By.tagName("button"));
        button.click();
        Assert.assertTrue(wait.waitForElementInvisible(button));

        WebElement loading = wait.waitForVisibilityBy(By.id("loading"));
        Assert.assertTrue(loading.isDisplayed());
        Assert.assertTrue(wait.waitForElementInvisible(loading));

        Assert.assertTrue(wait.waitForVisibilityBy(By.cssSelector("#finish h4")).isDisplayed());
    }
}
