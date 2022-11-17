package steps;

import io.qameta.allure.Step;
import pages.CheckoutPage;

public class CheckoutStep {
    CheckoutPage checkoutPage;

    public CheckoutStep() {
        checkoutPage = new CheckoutPage();

    }

    @Step("если что удалить, если вдруг тесты вздумают сойти с ума")
    public void addToCart() {
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShoppingCartContainer();
        checkoutPage.clickCheckoutButton();
    }

    @Step
    public void ifCheckoutSuccess(String firstName, String lastName, String zip) {
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipInput(zip);
    }

    @Step
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

    public void infoOfElement() {
        checkoutPage.clickInfoOfElement();
    }
}