package tests;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import services.BrowsersService;

public class Task8 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
    }

    @Test
    public void tryBasicLocatorsTest() {
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
    }

    /**
     * CssSelectors
     */
    @Test
    public void tryCssTest() {
        driver.get(ReadProperties.getUrl());
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();
// по .class
        driver.findElement(By.cssSelector(".primary_header"));
// по .class1.class2
        driver.findElements(By.cssSelector(".btn.btn_primary"));
// по #id
        driver.findElement(By.cssSelector("#menu_button_container"));
// по tagname
        driver.findElement(By.cssSelector("footer"));
// по tagname.class
        driver.findElement(By.cssSelector("div.footer_copy"));
// по [attribute=value]
        driver.findElement(By.cssSelector("[data-test='product_sort_container']"));
// по [attribute~=value]
        driver.findElement(By.cssSelector("[alt~='Bolt']"));
// по [attribute|=value]
        driver.findElement(By.cssSelector("[class|='footer']"));
// по [attribute^=value]
        driver.findElement(By.cssSelector("[class^='r']"));
// по [attribute$=value]
        driver.findElement(By.cssSelector("[class$='ooter_robot']"));
// по [attribute*=value]
        driver.findElement(By.cssSelector("[alt*='Bol']"));
    }

    @Test
    public void tryXPathTest() {
        driver.get(ReadProperties.getUrl());
        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.name("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("login-button")).click();
/**по Xpath*/
//Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
//Поиск по тексту, например By.xpath("//tag[text()='text']");
        driver.findElement(By.xpath("//*[text() ='Sauce Labs Bike Light']"));
//Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
        driver.findElement(By.xpath("//div[contains(@id, 'inventory_contain')]"));
//Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
        driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
//ancestor, например //*[text()='Enterprise Testing']//ancestor::div
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']/ancestor::div"));
//descendant
        driver.findElement(By.xpath("//*[@id='contents_wrapper']/descendant::button"));
//following
        driver.findElement(By.xpath("//*[@class='inventory_item']/following::div"));
//parent
        driver.findElement(By.xpath("//*[@id='menu_button_container']/parent::div"));
//preceding
        driver.findElement(By.xpath("//*[@class='title']/preceding::div"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
