package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import steps.LoginStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;

    @BeforeMethod
    public void setUp() {
        driver = new BrowsersService().getDriver();
        //driver.get(ReadProperties.getUrl());

        //loginStep = new LoginStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
