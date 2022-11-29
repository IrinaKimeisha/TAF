package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> uiElements;
    private List<String> valueList;
    private List<String> textList;

    public RadioButton(WebDriver driver, By by) {
        uiElements = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(by)) {
            UIElement tmpElement = new UIElement(driver, webElement);
            uiElements.add(tmpElement);
            valueList.add(tmpElement.getAttribute("value"));
            textList.add(tmpElement.findElement(By.xpath("parent::*/strong")).getText());
        }
    }

    public void selectByValue(String value) {
        uiElements.get(valueList.indexOf(value)).click();
    }

    public void selectByText(String text) {
        uiElements.get(textList.indexOf(text)).click();
    }
}
