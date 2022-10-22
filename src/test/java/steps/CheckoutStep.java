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
        // оставить
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShoppingCartContainer();
        checkoutPage.clickCheckoutButton();
    }

    public CheckoutPage checkout(String firstName, String lastName, String zip) {
        //оставить
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipInput(zip);
        checkoutPage.clickContinueButton();
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkoutSuccess(String firstName, String lastName, String zip) {
        checkout(firstName, lastName, zip);
        return new CheckoutPage(driver);
    }

    public CheckoutPage checkoutCancel(String firstName, String lastName, String zip) {
        checkout(firstName, lastName, zip);
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
}