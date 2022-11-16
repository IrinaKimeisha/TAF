package tests.gui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.tagName("h3")).isDisplayed();
        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frameElement);
        driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(0);//если никак фреймы не обозначены по порядковому номеру, начало с 0, если нет такого - ошибка NoSuchFrameException
        driver.findElement(By.xpath("//p[.= 'Your content goes here.']")).isDisplayed();
        //driver.switchTo().parentFrame(); //переключиться в родительский документ
        driver.switchTo().defaultContent(); // переключит в первоначальный документ
        driver.findElement(By.tagName("h3")).isDisplayed();

        // чтобы работать с фреймом в него нужно переключаться
        // после работы с фреймом обязательно переключиться обратно
    }

    //из дока Алекса
    /*public class FrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        //driver.switchTo().frame(frameElement);
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        //driver.switchTo().parentFrame(); // Переключиться в родительский документ
        driver.switchTo().defaultContent(); // Переключает в первоначальный документ

        driver.findElement(By.tagName("h3")).isDisplayed();
    }
*/
}
