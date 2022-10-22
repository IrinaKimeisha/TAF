package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;
import pages.CheckoutPage;
import steps.CheckoutStep;

public class CheckoutTest extends BaseTest {
    CheckoutPage checkoutPage;
    CheckoutStep checkoutStep;
    @Test
    public void successfulCheckoutTest() {
        loginSauceDemoStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.checkoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.finishButton();
    }
    @Test
    public void cancelCheckoutTest() {
        loginSauceDemoStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        checkoutStep.shoppingCartIcon();
        checkoutStep.checkoutCancel(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.cancelButton();
        Assert.assertTrue(checkoutPage.isPageOpened());
    }
    @Test // оставить
    public void openCatalogueTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(new CataloguePage(driver).isPageOpened());
    }
    @Test
    public void returnToCartTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        checkoutStep.addToCart();
        checkoutStep.checkoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        checkoutStep.continueButton();
        checkoutStep.shoppingCartIcon();
    }
    @Test
    public void openCheckoutPageTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        checkoutStep.checkoutSuccess(ReadProperties.firstNAme(), ReadProperties.lastName(), ReadProperties.zip());
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(new CheckoutPage(driver).isPageOpened());
    }
}
