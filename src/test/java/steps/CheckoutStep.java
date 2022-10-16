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
    public void addToCart(){
        checkoutPage.clickAddToCartButton();
        checkoutPage.clickShoppingCartContainer();
        checkoutPage.clickCheckoutButton();
    }
    public void checkout(String firstName, String lastName, String zip){
        checkoutPage.setFirstNameInput(firstName);
        checkoutPage.setLastNameInput(lastName);
        checkoutPage.setZipInput(zip);
        checkoutPage.clickContinueButton();
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
    public void finishButton(){
        checkoutPage.clickFinishButton();
    }
    public void cancelButton(){
        checkoutPage.clickCancelButton();
    }
    public void shoppingCartIcon(){
        checkoutPage.clickShoppingCartContainer();
    }
}
