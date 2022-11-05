package tests;

import baseEntities.BaseTest;
import com.codeborne.selenide.*;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class SelenideTest extends BaseTest {

    //@Test
    public void loginTest() {
        open("https://aqa2101.testrail.io/");

        SelenideElement username = $(By.id("name"));
        username.setValue(ReadProperties.username());

        $("#password").setValue(ReadProperties.password());

        SelenideElement loginButton = $("#button_primary");
        loginButton
                .shouldBe(exist, enabled)
                .click();

        $(withText("All Projects")).shouldBe(visible).shouldHave(text("All Projects"));

        $(By.xpath("//div[contains(text(), 'All Projects')]")).shouldBe(visible).shouldHave(text("All Projects"));

        boolean result = isChrome();
        result = isFirefox();
        result = isHeadless();
    }

    @Test
    public void openLoginPageTest() {
        LoginStep loginStep = open("", LoginStep.class);
        DashboardPage dashboardPage = loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());

        dashboardPage.getHeaderTitleLabel().shouldBe(visible);
        dashboardPage.isHeaderTitleLabelDisplayed();
    }

    @Test
    public void openLoginPageTest1() {
        LoginStep loginStep = open("", LoginStep.class);
        DashboardPage dashboardPage = loginStep.loginSuccessful(ReadProperties.username(), "1");

        dashboardPage.getHeaderTitleLabel().shouldBe(visible);
        dashboardPage.isHeaderTitleLabelDisplayed();

        $$("#employees").shouldHave(
                texts(
                        "Alex Trostyanko",
                        "Ivan Petrov",
                        "Maria Gerasimenko"
                )
        );
    }
}
