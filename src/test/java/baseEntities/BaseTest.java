package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.CheckoutStep;
import steps.LoginSauceDemoStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginSauceDemoStep loginSauceDemoStep;
    protected CheckoutStep checkoutStep;


    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
        driver.get(ReadProperties.getUrl());

        loginSauceDemoStep = new LoginSauceDemoStep(driver);
        checkoutStep = new CheckoutStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}