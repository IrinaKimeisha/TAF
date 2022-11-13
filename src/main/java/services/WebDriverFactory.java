package services;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class WebDriverFactory {
    private static final WebDriver driver;

    static {
        driver = new BrowsersService().getDriver();
    }
}
