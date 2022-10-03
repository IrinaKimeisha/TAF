package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import services.AdvancedDriver;
import services.BrowsersService;
import services.SimpleDriver;

public class FirstTest {
    @Test
    public void simpleDriverTest() throws InterruptedException {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void advancedDriverTest() throws InterruptedException {
        AdvancedDriver advancedDriver = new AdvancedDriver();
        WebDriver driver = advancedDriver.getDriver();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void browsersServicesTest() throws InterruptedException {
        BrowsersService browsersService = new BrowsersService();
        WebDriver driver = browsersService.getDriver();
        Thread.sleep(2000);
        driver.quit();
    }

}
