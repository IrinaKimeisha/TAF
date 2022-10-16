package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By cartButtonLocator = By.className("shopping_cart_link");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return cartButtonLocator;
    }

    public WebElement getCartButton(){
        return driver.findElement(cartButtonLocator);
    }
    public void clickCartButton(){
        getCartButton().click();
    }
}
