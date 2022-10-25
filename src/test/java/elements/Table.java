package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;

    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
    }

    public Table(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public UIElement getCell(String columnName, int rowNumber) {
        return null;
    }

    public UIElement getCell(String targetColumnName, String targetValue, String columnName) {
        return null;
    }

    private List<UIElement> getColumns() {
        return uiElement.findUIElements(By.tagName("th"));
    }

    public TableRow getRow(int i) {
        ArrayList<UIElement> list = uiElement.findUIElements(By.tagName("tr"));
        return new TableRow(driver, list.get(i));
    }

    public UIElement getCell(int columnNumber, int rowNumber) {
        TableRow row = getRow(rowNumber);
        ArrayList<UIElement> list = row.findUIElements(By.tagName("td"));

        return list.get(columnNumber);
    }

    public UIElement getElementFromCell(UIElement cellElement, By by) {
        return cellElement.findElement(by);
    }
}
