package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage extends BasePage {
    // Блок описания селекторов для элементов
    private final By pageIdentifier = By.xpath("");

    // Блок инициализации страницы
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }
}