package steps;

import io.qameta.allure.Step;
import pages.CataloguePage;
import pages.LoginSauceDemoPage;

import static com.codeborne.selenide.Selenide.page;

public class LoginSauceDemoStep {
    LoginSauceDemoPage loginSauceDemoPage;

    public LoginSauceDemoStep() {
        loginSauceDemoPage = new LoginSauceDemoPage();
    }

    public void login(String username, String psw) {
        loginSauceDemoPage.setUsername(username);
        loginSauceDemoPage.setPsw(psw);
        loginSauceDemoPage.clickLoginButton();
    }
    public CataloguePage loginSuccessful(String username, String psw) {
        login(username, psw);

        return page(CataloguePage.class);
    }
    public LoginSauceDemoPage loginIncorrect(String username, String psw) {
        login(username, psw);

        return page(LoginSauceDemoPage.class);
    }
}
