package tests;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckoutTest {
    @Description("Тест без Steps, с ними не разобралась")
    @Test
    public void successfulAddingItemAndCheckoutTest() {
        open(ReadProperties.getUrl());

        $(By.id("user-name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#login-button").click();

        $(By.xpath("//span[contains(text(), 'Products')]")).shouldBe(visible);

        $(By.id("add-to-cart-sauce-labs-backpack")).click();
        $(By.className("shopping_cart_link")).click();
        $(By.id("checkout")).click();

        SelenideElement firstName = $(By.id("first-name"));
        SelenideElement lastName = $(By.id("last-name"));
        SelenideElement zip = $(By.id("postal-code"));

        firstName.setValue(ReadProperties.firstNAme());
        lastName.setValue(ReadProperties.lastName());
        zip.setValue(ReadProperties.zip());

        SelenideElement continueButton = $(By.id("continue"));
        continueButton.click();

        SelenideElement finishButton = $(By.id("finish"));
        finishButton.click();

        $(By.id("back-to-products")).shouldBe(visible);

    }
}
