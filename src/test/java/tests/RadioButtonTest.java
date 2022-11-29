package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void selectByValueTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://aqa21022.testrail.io/index.php?/admin/users/add");

        RadioButton radioButton = new RadioButton(driver, By.name("invite"));

        radioButton.selectByValue("0");
    }
}
