package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CataloguePage {
    private final static String pagePath = "inventory.html";
    private final By headerTitleLabelLocator = By.xpath("//span[contains(text(), 'Products')]"); //показатель того, что страница каталога открыта
    protected By getPageIdentifier() {return headerTitleLabelLocator;}
}
