package tests;
/*  Открыть сайт http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf
    Выбрать пол ‘женский’ из выпадающего списка
    Ввести ‘Креатинин’ = 80,Ввести ‘Возраст’ = 38,Ввести ‘Вес’ = 55,Ввести ‘Рост’ = 163
    Нажать на кнопку ‘Рассчитать’
    Проверить результаты: ‘MDRD: 74 (мл/мин/1,73кв.м)’
    Проверить результаты: ‘ХБП: 2 стадия (при наличии почечного повреждения)’
    Проверить результаты: ‘Cockroft-Gault: 70 (мл/мин)’
    Проверить результаты: ‘Поверхность тела:1.58 (кв.м)’
    Закрыть окно браузера
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import services.BrowsersService;

public class CalcClinicTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void ClinicTest() {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByVisibleText("женский");
        WebElement kreatinin = driver.findElement(By.id("oCr"));
        kreatinin.sendKeys("80");
        WebElement age = driver.findElement(By.id("oAge"));
        age.sendKeys("38");
        WebElement weight = driver.findElement(By.id("oWeight"));
        weight.sendKeys("55");
        WebElement height = driver.findElement(By.id("oHeight"));
        height.sendKeys("163");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"Form1\"]/ul/li[6]/input[1]"));
        button.click();
        WebElement MDRD = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(MDRD.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");
        WebElement HBP = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(HBP.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");
        WebElement CG = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(CG.getText(), "Cockroft-Gault: 70 (мл/мин)");
        WebElement BSA = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(BSA.getText(), "Поверхность тела:1.58 (кв.м)");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
