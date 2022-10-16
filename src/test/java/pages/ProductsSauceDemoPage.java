package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsSauceDemoPage extends BasePage {
    private final static String pagePath = "inventory.html";

    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//*[@id='header_container']/div[2]/span");

    // Блок инициализации страницы
    public ProductsSauceDemoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitleLabel() {
        return driver.findElement(headerTitleLabelLocator);
    }

    //второй способ, принять как данность ☺
  /* public boolean isHeaderTitleDisplayed () {
       return getHeaderTitleLabel().isDisplayed();
   }*/


}
