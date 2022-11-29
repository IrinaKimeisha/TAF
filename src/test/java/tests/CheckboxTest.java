package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.CheckBox;
import elements.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    @Test
    public void selectTest(){
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://aqa21022.testrail.io/index.php?/admin/projects/add/1");

        CheckBox checkBox = new CheckBox(driver, By.name("show_announcement"));

        checkBox.setFlag();
        checkBox.isSelected();
        checkBox.removeFlag();
    }
}
