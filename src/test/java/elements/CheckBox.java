package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void set() {
        click(true);
    }

    public void remove() {
        click(false);
    }

    private void click(boolean flag) {
        if (flag != uiElement.isSelected()) {
            uiElement.click();
        }
    }


}
