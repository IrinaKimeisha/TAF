package pages.projects;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseProjectPage extends BasePage {
    private final By nameInputLocator = By.id("name");

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    public WebElement nameInput() { return driver.findElement(nameInputLocator); }
}
