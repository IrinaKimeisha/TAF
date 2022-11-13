package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {
    private UIElement uiElement;
    private WebDriver driver;

    public RadioButton(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
        this.driver = driver;
    }

    public RadioButton(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public void selectRadioButtonByNumber(int number) {
        clickRadioButton(number);
    }

    private void clickRadioButton(int value) {
        switch (value) {
            case 1:
                driver.findElement(By.id("suite_mode_single")).click();
                break;
            case 2:
                driver.findElement(By.id("suite_mode_single_baseline")).click();
                break;
            case 3:
                driver.findElement(By.id("suite_mode_multi")).click();
                break;
        }
    }
}
