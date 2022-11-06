package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    @Override
    protected By getPageIdentifier() {
        return checkoutButtonLocator;
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //селекторы
    private final By firstNameInputLocator = By.id("first-name");
    private final By lastNameInputLocator = By.id("last-name");
    private final By zipInputLocator = By.id("postal-code");
    private final By continueButtonLocator = By.className("submit-button");
    private final By cancelButtonLocator = By.id("cancel");
    private final By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartContainerLocator = By.id("shopping_cart_container");
    private final By checkoutButtonLocator = By.id("checkout");
    private final By finishButtonLocator = By.className("btn_action");
    private final By errorTextLocator = By.className("error-message-container");
    private final By infoOfElementLocator = By.className("inventory_item_name");


    //атомарные методы
    public WebElement getFirstNameInput() {
        return driver.findElement(firstNameInputLocator);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastNameInputLocator);
    }

    public WebElement getZipInput() {
        return driver.findElement(zipInputLocator);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButtonLocator);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButtonLocator);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finishButtonLocator);
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(addToCartButtonLocator);
    }

    public WebElement getShoppingCartContainer() {
        return driver.findElement(shoppingCartContainerLocator);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButtonLocator);
    }

    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }

    public WebElement getInfoOfElementElement() {
        return driver.findElement(infoOfElementLocator);
    }


    public void setFirstNameInput(String value) {
        getFirstNameInput().sendKeys(value);
    }

    public void setLastNameInput(String value) {
        getLastNameInput().sendKeys(value);
    }

    public void setZipInput(String value) {
        getZipInput().sendKeys(value);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void clickCancelButton() {
        getCancelButton().click();
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickInfoOfElement() {
        getInfoOfElementElement().click();
    }

    public void clickShoppingCartContainer() {
        getShoppingCartContainer().click();
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }


}
