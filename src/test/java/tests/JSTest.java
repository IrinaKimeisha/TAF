package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSTest extends BaseTest {

    @Test
    public void jsTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");

        WebElement webElement = driver.findElement(By.id("ui-id-2"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments [0].click;", webElement);

        Thread.sleep(5000);
    }
}
