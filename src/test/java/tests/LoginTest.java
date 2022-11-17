package tests;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    @Description("Успешный вход на сайт. Версия 1")
    @Test
    public void loginTest1() {

        open(ReadProperties.getUrl());

        $(By.id("user-name")).setValue(ReadProperties.username());
        $("#password").setValue(ReadProperties.password());
        $("#login-button").click();

        $(By.xpath("//span[contains(text(), 'Products')]")).shouldBe(visible);
    }

    @Description("Успешный вход на сайт. Версия 2")
    @Test
    public void loginTest2() {

        open(ReadProperties.getUrl());

        SelenideElement username = $(By.id("user-name"));
        SelenideElement psw = $(By.id("password"));
        SelenideElement loginButton = $(By.id("login-button"));

        username.setValue(ReadProperties.username());
        psw.setValue(ReadProperties.password());
        loginButton.click();

        $(By.xpath("//span[contains(text(), 'Products')]")).shouldBe(exist);
    }
}
