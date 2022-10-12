package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TopMenuPage;
import pages.projects.AddProjectPage;
import pages.projects.UpdateProjectPage;
import services.BrowsersService;
import steps.LoginStep;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test
    public void successLoginTest1() {
        Assert.assertTrue(
                loginStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }

    @Test
    public void incorrectUsernameTest() {
        Assert.assertEquals(
                loginStep.loginIncorrect("sdsd", ReadProperties.password())
                        .getErrorTextElement().getText()
                , "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    public void incorrectPswTest() {
        new UpdateProjectPage(driver).nameInput();
        new AddProjectPage(driver).getSaveButton();
    }
}
