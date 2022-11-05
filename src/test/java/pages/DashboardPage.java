package pages;

import baseEntities.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private final static String pagePath = "index.php?/dashboard";

    // Блок описания селекторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(text(), 'TestRail QA')]");


    // Блок инициализации страницы
    public void openPageByUrl() {
        open(pagePath);
    }

    // Блок атомарных методов
    public SelenideElement getHeaderTitleLabel() {
        return $(headerTitleLabelLocator);
    }

    public boolean isHeaderTitleLabelDisplayed() {
        return getHeaderTitleLabel().isDisplayed();
    }
}
