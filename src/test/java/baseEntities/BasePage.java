package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitsService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);


    }

    public BasePage(WebDriver driver, boolean openPageByUr) {
        this.driver = driver;
        waitsService = new WaitsService(driver);
        if (openPageByUr) {
            openPage();
        }

    }

    protected abstract By getPageIdentifier();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public abstract void openPage() {

    }
}
