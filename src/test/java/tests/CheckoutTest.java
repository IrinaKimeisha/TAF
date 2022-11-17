package tests;

import baseEntities.BaseSelenideTest;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import steps.CheckoutStep;
import steps.LoginSauceDemoStep;


import static com.codeborne.selenide.Selenide.open;

public class CheckoutTest extends BaseSelenideTest {

    @Story("Test 1")
    @Test(description = "успешная регистрация и добавление в корзинку")
    public void successfulCheckoutTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        checkoutStep.addToCart();
        checkoutStep.ifCheckoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.finishButton();
    }

    @Story("Test 2")
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

    @Story("Test 3")
    @Test
    @Description("Возврат на страницу каталога")
    public void returnToCatalogueTest() {
        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        CheckoutStep checkoutStep = open("", CheckoutStep.class);
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());

        checkoutStep.addToCart();
        checkoutStep.ifCheckoutIncorrect(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.cancelButton();
    }

    @Story("Test 4")
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
