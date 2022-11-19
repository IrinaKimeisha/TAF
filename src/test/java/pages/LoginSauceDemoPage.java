package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class LoginSauceDemoPage {
    // Блок описания селекторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.className("error-message-container");
    // Блок атомарных методов
    public SelenideElement getUsernameInput() {
        return $(usernameInputLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getPswInput() {
        return $(pswInputLocator).shouldBe(Condition.visible);
    }

    public SelenideElement getLoginButton() {
        return $(loginButtonLocator);
    }
    public void setUsername(String value) {
        getUsernameInput().setValue(value);
    }

    public void setPsw(String value) {
        getPswInput().setValue(value);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public SelenideElement getErrorTextElement() {
        return $(errorTextLocator).shouldBe(Condition.visible);
    }
}
