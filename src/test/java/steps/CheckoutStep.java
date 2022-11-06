package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutStep extends BaseStep {
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        super(driver);

        checkoutPage = new CheckoutPage(driver);

    }
    public void addToCart() {
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShoppingCartContainer();
        checkoutPage.clickCheckoutButton();
    }

    public void ifCheckoutSuccess(String firstName, String lastName, String zip) {
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipInput(zip);
    }
    public CheckoutPage ifCheckoutIncorrect(String firstName, String lastName, String zip) {
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipInput(zip);

        return checkoutPage;
    }

    public void continueButton() {
        checkoutPage.clickContinueButton();
    }

    public void finishButton() {
        checkoutPage.clickFinishButton();
    }

    public void cancelButton() {
        checkoutPage.clickCancelButton();
    }

    public void shoppingCartIcon() {
        checkoutPage.clickShoppingCartContainer();
    }
    public void infoOfElement() {checkoutPage.clickInfoOfElement();}
}