package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

/*Написать следующие тесты по сценариям ниже:
1.Открыть сайт https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx
2.Ввести параметры для расчета
3.Нажать на кнопку ‘Рассчитать’
4.Проверить корректность вычислений
5.Закрыть окно браузера*/

public class CalkFloorTest {
    private WebDriver driver;

    @BeforeMethod

    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void calkFloorTest() {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        WebElement width = driver.findElement(By.id("el-f-width"));
        width.sendKeys("3");
        WebElement length = driver.findElement(By.id("el-f-length"));
        length.sendKeys("4");

        WebElement selectYourRoom = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectYourRoom);
        selectRoom.selectByVisibleText("Ванная");

        WebElement selectYourHeatingType = driver.findElement(By.id("heating_type"));
        Select selectHeatingType = new Select(selectYourHeatingType);
        selectHeatingType.selectByVisibleText("Основное отопление");

        WebElement looses = driver.findElement(By.id("el-f-losses"));
        looses.sendKeys(""); // внести изменения

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
