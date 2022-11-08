package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage{

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
    public SelenideElement getFirstNameInput() {
        return $(firstNameInputLocator);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator);
    }

    public SelenideElement getZipInput() {
        return $(zipInputLocator);
    }

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator);
    }

    public SelenideElement getCancelButton() {
        return $(cancelButtonLocator);
    }

    public SelenideElement getFinishButton() {
        return $(finishButtonLocator);
    }

    public SelenideElement getAddToCartButton() {
        return $(addToCartButtonLocator);
    }

    public SelenideElement getShoppingCartContainer() {
        return $(shoppingCartContainerLocator);
    }

    public SelenideElement getCheckoutButton() {
        return $(checkoutButtonLocator);
    }

    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator);
    }

    public SelenideElement getInfoOfElementElement() {
        return $(infoOfElementLocator);
    }


    public void setFirstNameInput(String value) {
        getFirstNameInput().setValue(value);
    }

    public void setLastNameInput(String value) {
        getLastNameInput().setValue(value);
    }

    public void setZipInput(String value) {
        getZipInput().setValue(value);
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
