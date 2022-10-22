package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CataloguePage;
import pages.LoginSauceDemoPage;

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
    public CataloguePage loginSuccessful(String username, String psw) {
        login(username, psw);
        return new CataloguePage(driver);
    }
    public LoginSauceDemoPage loginIncorrect(String username, String psw) {
        login(username, psw);
        return loginSauceDemoPage;
    }
}
