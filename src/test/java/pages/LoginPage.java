package pages;

import baseEntities.BasePage;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    @FindBy(id = "name")
   public WebElement emailInput;
    @FindBy(id = "password")
    public  WebElement pswInput;
    @FindBy (id = "button_primary")
    public WebElement loginButton;
    @FindBy( className ="error-text" )
    public WebElement errorText;

    // Блок инициализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Блок атомарных методов

    public void setEmail(String value) { emailInput.sendKeys(value); }
    public void setPsw(String value) { pswInput.sendKeys(value); }
    public void clickLoginButton() { loginButton.click(); }
    public WebElement getErrorTextElement() { return errorText; }
}
