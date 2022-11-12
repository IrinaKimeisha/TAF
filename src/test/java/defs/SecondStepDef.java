package defs;

import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import services.BrowsersService;
import steps.LoginStep;

public class SecondStepDef {
    WebDriver driver;

    @Given("открыт браузер") //часть с аннотацией Given - сниппет
    public void openBrowser() {
        driver = new BrowsersService().getDriver();
    }

    @When("страница логина открыта")
    public void openLoginPage() {
        driver.get(ReadProperties.getUrl());

    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        LoginStep loginStep = new LoginStep(driver);
        User user = new User();
        /*user.setEmail(username);
        user.setPassword(password);
        loginStep.loginSuccessful(user);
         */
    }

    @Then("Dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Then("project with ID = {int} is displayed")
    public void isProjectDisplayed(int ID) {
        Assert.assertEquals(23, ID);
    }



    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("a description with text {string}")
    public void aDescriptionWithText(String text) {
        System.out.println("text");
    }
}
