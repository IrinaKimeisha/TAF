package baseEntities;

import configuration.ReadProperties;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.BrowsersService;
import steps.LoginStep;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;

    @BeforeMethod(description = "Настройка")
    @Description("Настройка")
    public void setUp(ITestContext iTestContext) {
        driver = new BrowsersService().getDriver();
        // Solution 1
        iTestContext.setAttribute("driver", driver);
        // Solution 1 - Finish

        driver.get(ReadProperties.getUrl());

        loginStep = new LoginStep(driver);
    }

    @AfterMethod(description = "Завершение")
    public void tearDown(ITestResult testResult) {
        // Solution - 2: Плохое решение - потому, что Screenshot добавляется в шаг TearDown
        /*
        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        }
        */
        driver.quit();
    }

    // Solution - 2:
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
    // Solution - 2: Finish
}
