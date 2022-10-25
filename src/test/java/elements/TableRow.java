package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TableRow {
    private UIElement uiElement;

    public TableRow(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public TableRow(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public TableRow(WebDriver driver, UIElement uiElement) {
        this.uiElement = uiElement;
    }

    public ArrayList<UIElement> findUIElements(By by) {
        return uiElement.findUIElements(by);
    }

    public UIElement getCell(int columnNumber) {
        ArrayList<UIElement> list = uiElement.findUIElements(By.tagName("td"));

        return list.get(columnNumber);
    }
}
