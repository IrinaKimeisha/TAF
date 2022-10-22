package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CataloguePage;

public class LoginSauceDemoTest extends BaseTest {

    @Test
    public void successLoginTest() {
        loginSauceDemoStep.login(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(new CataloguePage(driver).isPageOpened());
    }

    // Вариант проще
    @Test
    public void successLoginTest1() {
        Assert.assertTrue(
                loginSauceDemoStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void incorrectUserNameTest() {

        Assert.assertEquals(
                loginSauceDemoStep.loginIncorrect("BOO!", ReadProperties.password())
                        .getErrorTextElement().getText()
                , "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectPswTest() {
        Assert.assertEquals(
                loginSauceDemoStep.loginIncorrect(ReadProperties.username(), "12345")
                        .getErrorTextElement().getText()
                , "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void incorrectUsernameAndPswTest() {
        Assert.assertEquals(
                loginSauceDemoStep.loginIncorrect("BOO", "12345")
                        .getErrorTextElement().getText()
                , "Epic sadface: Username and password do not match any user in this service");
    }
}
