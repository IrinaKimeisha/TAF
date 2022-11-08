package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //селекторы
    @FindBy(id = "first-name")
    public WebElement firstNameInputLocator;

    @FindBy(id = "last-name")
    public WebElement lastNameInputLocator;

    @FindBy(id = "postal-code")
    public WebElement zipInputLocator;

    @FindBy(className = "submit-button")
    public WebElement continueButtonLocator;

    @FindBy(id = "cancel")
    public WebElement cancelButtonLocator;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartButtonLocator;

    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartContainerLocator;

    @FindBy(id = "checkout")
    public WebElement checkoutButtonLocator;

    @FindBy(className = "btn_action")
    public WebElement finishButtonLocator;

    @FindBy(className = "inventory_item_name")
    public WebElement infoOfElementLocator;

    //атомарные методы
    public void setFirstNameInput(String value) {
        firstNameInputLocator.sendKeys(value);
    }

    public void setLastNameInput(String value) {
        lastNameInputLocator.sendKeys(value);
    }

    public void setZipInput(String value) {
        zipInputLocator.sendKeys(value);
    }

    public void clickContinueButton() {
        continueButtonLocator.click();
    }

    public void clickCancelButton() {
        cancelButtonLocator.click();
    }

    public void clickAddToCartButton() {
        addToCartButtonLocator.click();
    }

    public void clickInfoOfElement() {
        infoOfElementLocator.click();
    }

    public void clickShoppingCartContainer() { shoppingCartContainerLocator.click();}
    public void clickFinishButton() {
        finishButtonLocator.click();
    }

    public void clickCheckoutButton() {
        checkoutButtonLocator.click();
    }
}
