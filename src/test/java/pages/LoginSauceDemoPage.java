package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSauceDemoPage extends BasePage {
    // Блок описания селекторов для элементов
    private final By usernameInputLocator = By.id("user-name");
    private final By pswInputLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorTextLocator = By.className("error-message-container");

    // Блок инициализации страницы
    public LoginSauceDemoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator;
    }

    // Блок атомарных методов
    public WebElement getUsernameInput() {
        return driver.findElement(usernameInputLocator);
    }

    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButtonLocator);
    }


    public void setUsername(String value) {
        getUsernameInput().sendKeys(value);
    }

    public void setPsw(String value) {
        getPswInput().sendKeys(value);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
    public WebElement getErrorTextElement(){
        return driver.findElement(errorTextLocator);
    }

}
