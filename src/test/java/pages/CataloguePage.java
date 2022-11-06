package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CataloguePage extends BasePage {
    private final static String pagePath = "inventory.html";
    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(), 'Products')]"); //показатель того, что страница каталога открыта

    public CataloguePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }
}
