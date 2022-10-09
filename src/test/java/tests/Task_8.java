package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Task_8 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @Test
    public void tryLocatorsTest(){
        driver.get(ReadProperties.getUrl());
// поиск по ID
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
// поиск по Name
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
// поиск по className
        driver.findElement(By.className("shopping_cart_link")).click();

        WebElement price = driver.findElement(By.className("inventory_item_price"));
        Assert.assertEquals(price.getText(), "$49.99");
        WebElement nameOfItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(nameOfItem.getText(), "Sauce Labs Fleece Jacket");

// поиск по tagName
        driver.findElement(By.tagName("footer"));
        /*   ПОЧЕМУ НЕ НАХОДИТ???????
// поиск по linkedText
        driver.findElement(By.linkText("Reset App State".toUpperCase())).click();
// поиск по partialLinkText
        driver.findElement(By.partialLinkText("Reset App".toUpperCase())).click(); */

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
