package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class BasicLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void basicLocatorsTest() {
        driver.get(ReadProperties.getUrl());
// Find webElement by ID
        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
// Find webElement by name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
// Find webElement by TagName
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void basicLocatorsTest2() {
        driver.get(ReadProperties.getUrl());
// Find webElement by linkText
        driver.findElement(By.linkText("Forgot your password?")).click();
// Find webElement by className
        driver.findElement(By.className("forgot_passwordpage-request-cancel")).click();
//Find webElement by linkText
        driver.findElement(By.partialLinkText("your password?")).click();
    }
}
