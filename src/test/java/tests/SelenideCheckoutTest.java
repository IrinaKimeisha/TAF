package tests;

import baseEntities.BaseSelenideTest;
import com.codeborne.selenide.Condition;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.CataloguePage;
import steps.CheckoutStep;
import steps.LoginSauceDemoStep;

import static com.codeborne.selenide.Selenide.open;

public class SelenideCheckoutTest extends BaseSelenideTest {

    @Test
    public void checkoutSuccessTest() {

        LoginSauceDemoStep loginSauceDemoStep = open("", LoginSauceDemoStep.class);
        CataloguePage cataloguePage = open("", CataloguePage.class);

    }

}
