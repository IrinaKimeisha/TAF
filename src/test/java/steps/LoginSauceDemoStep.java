package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginSauceDemoPage;
import pages.ProductsSauceDemoPage;

public class LoginSauceDemoStep extends BaseStep {

    LoginSauceDemoPage loginSauceDemoPage;

    public LoginSauceDemoStep(WebDriver driver) {
        super(driver);
        loginSauceDemoPage = new LoginSauceDemoPage(driver);
    }

    public void login(String username, String psw) {
        loginSauceDemoPage.setUsername(username);
        loginSauceDemoPage.setPsw(psw);
        loginSauceDemoPage.clickLoginButton();
    }
    public ProductsSauceDemoPage loginSuccessful(String username, String psw) {
        login(username, psw);
        return new ProductsSauceDemoPage(driver);
    }
    public LoginSauceDemoPage loginIncorrect(String username, String psw) {
        login(username, psw);
        return loginSauceDemoPage;

    }
    public void logout(){

    }
}
