package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 30;

    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
    }

    public BasePage(WebDriver driver, boolean openPageByURL) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
        if (openPageByURL) {
            openPage();
        }
        waitForOpen();

    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public abstract void openPage();
    protected void waitForOpen() throws InterruptedException {
        int tryCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator
                && tryCount < (WAIT_FOR_PAGE_LOADED_IN_SECONDS)) {
            tryCount++;
            Thread.sleep(1000);
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }

}
