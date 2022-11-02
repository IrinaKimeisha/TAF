package baseEntities;

import configuration.ReadProperties;
import configuration.UpdateEnvironmentProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.LoginStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    private Capabilities capabilities;

    @BeforeMethod(description = "Настройка")
    @Description("Настройка")
    public void setUp(@NotNull ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        iTestContext.setAttribute("driver", driver);

        capabilities = ((RemoteWebDriver)driver).getCapabilities();

        // Open te main page
        driver.get(ReadProperties.getUrl());

        // Init steps
        loginStep = new LoginStep(driver);
    }

    @AfterMethod(description = "Завершение")
    public void tearDown(ITestResult testResult) {

        driver.quit();
    }

    @AfterTest
    public void storeInfo() {
        UpdateEnvironmentProperties.setProperty("os.name", System.getProperty("os.name"));
        UpdateEnvironmentProperties.setProperty("user.home", System.getProperty("user.home"));
        UpdateEnvironmentProperties.setProperty("browser.name", capabilities.getBrowserName());
        UpdateEnvironmentProperties.setProperty("browser.version", capabilities.getBrowserVersion());
        UpdateEnvironmentProperties.storeEnvProperties();
    }
}
