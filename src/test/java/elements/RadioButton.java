package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    private UIElement uiElement;

    public RadioButton(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }
}
