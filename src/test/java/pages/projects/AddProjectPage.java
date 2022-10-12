package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BaseProjectPage {
    private final By saveButtonLocator = By.id("accept");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    public WebElement getSaveButton() {
        return driver.findElement(saveButtonLocator);
    }
}
