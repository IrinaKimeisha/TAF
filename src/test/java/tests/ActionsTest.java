package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        List<WebElement> targetElements = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(targetElements.get(0), 10, 10)
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))
                .build()
                .perform();
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath();
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }
}
