package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSauceDemoPage extends BasePage {
    // Блок описания селекторов для элементов
    @FindBy(id = "user-name")
    public WebElement usernameInputLocator;
    @FindBy(id = "password")
    public WebElement pswInputLocator;
    @FindBy(id = "login-button")
    public WebElement loginButtonLocator;

    // Блок инициализации страницы
    public LoginSauceDemoPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов
    public void setUsername(String value) {
        usernameInputLocator.sendKeys(value);
    }

    public void setPsw(String value) {
        pswInputLocator.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButtonLocator.click();
    }
}
