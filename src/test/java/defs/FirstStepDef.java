package defs;

import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import pages.LoginPage;
import services.BrowsersService;

public class FirstStepDef {
    WebDriver driver;

    @Given("открыт браузер") //часть с аннотацией Given - сниппет
    public void openBrowser() {
        System.out.println("Открыт браузер");
        //driver = new BrowsersService().getDriver();
    }

    @When("страница логина открыта")
    public void openLoginPage() {
        //driver.get(ReadProperties.getUrl());
        System.out.println("Страница логина открыта");
    }

    /*@After
    public void tearDown() {
        driver.quit();
    }*/

    @Then("отображается поле username")
    public void isUsernameFieldIsDisplayed() {
        // then - этот проверки
        // Assert.assertTrue(new LoginPage(driver).getEmailInput().isDisplayed());
        System.out.println("Проверка выполнена");
    }
}
