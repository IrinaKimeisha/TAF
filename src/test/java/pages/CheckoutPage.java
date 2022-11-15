package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

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
        return $(firstNameInputLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getLastNameInput() {
        return $(lastNameInputLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getZipInput() {
        return $(zipInputLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getContinueButton() {
        return $(continueButtonLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getCancelButton() {
        return $(cancelButtonLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getFinishButton() {
        return $(finishButtonLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getAddToCartButton() {
        return $(addToCartButtonLocator);
    }

    public SelenideElement getShoppingCartContainer() {
        return $(shoppingCartContainerLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getCheckoutButton() {
        return $(checkoutButtonLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getInfoOfElementElement() {
        return $(infoOfElementLocator).shouldBe(Condition.visible);
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
