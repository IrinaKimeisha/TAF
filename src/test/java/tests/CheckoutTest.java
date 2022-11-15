package tests;

import baseEntities.BaseSelenideTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import steps.CheckoutStep;
import steps.LoginSauceDemoStep;


import static com.codeborne.selenide.Selenide.open;

public class CheckoutTest extends BaseSelenideTest {

    @Test
    public void successfulCheckoutTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.finishButton();
    }

    @Test
    public void infoOfCheckoutTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.infoOfElement();
    }

    @Test
    public void returnToCatalogueTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        checkoutStep.addToCart();
        checkoutStep.ifCheckoutIncorrect(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.cancelButton();
    }

    @Test
    public void returnToCartTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.shoppingCartIcon();
    }
}
