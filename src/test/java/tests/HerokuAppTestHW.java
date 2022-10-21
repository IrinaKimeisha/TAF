package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class HerokuAppTestHW extends BaseTest {
    @Test
    public void contextMenuTest() {

        driver.get(ReadProperties.getUrl());
        actions
                .contextClick(wait.waitForVisibilityBy(By.id("hot-spot")))
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControlsCheckBoxTest() {
        driver.get(ReadProperties.getUrl1());
        actions
                .click(wait.waitForVisibilityBy(By.cssSelector("[label='blah']")))
                .click(wait.waitForVisibilityBy(By.cssSelector("[onclick='swapCheckbox()']")))
                .build()
                .perform();
        Assert.assertEquals(wait.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
    }

    @Test
    public void dynamicControlsInputTest() {
        driver.get(ReadProperties.getUrl1());
        WebElement input = wait.waitForVisibilityBy(By.cssSelector("[type = 'text']"));
        Assert.assertFalse(input.isEnabled());
        actions
                .click(wait.waitForVisibilityBy(By.cssSelector("[onclick='swapInput()']")))
                .build()
                .perform();
        Assert.assertEquals(wait.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(input.isEnabled());
    }

    @Test
    public void fileUploadTest() {
        driver.get(ReadProperties.getUrl2());
        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = HerokuAppTestHW.class.getClassLoader().getResource("Снимок экрана (52).jpeg").getPath();
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();
        Assert.assertEquals(wait.waitForExists(By.id("uploaded-files")).getText(), "Снимок экрана (52).jpeg");
    }

    @Test
    public void frameTest() {
        driver.get(ReadProperties.getUrl3());
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Your content goes here.");
    }
}
