package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HerokuAppTestHW extends BaseTest {
    @Test
    public void contextMenuTest(){
        driver.get(ReadProperties.getUrl());
        WebElement box = driver.findElement(By.id("hot-spot"));
        Alert alert = driver.switchTo().alert();



    }

}
