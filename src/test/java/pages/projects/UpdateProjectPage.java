package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateProjectPage extends BaseProjectPage {
    public UpdateProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }
}
