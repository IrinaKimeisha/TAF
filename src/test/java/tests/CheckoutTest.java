package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void successfulCheckoutTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.finishButton();
    }
    @Test
    public void infoOfCheckoutTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.infoOfElement();
    }

    @Test
    public void returnToCatalogueTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.cancelButton();
    }

    @Test
    public void returnToCartTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.shoppingCartIcon();
    }
}
