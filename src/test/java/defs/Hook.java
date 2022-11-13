package defs;

import baseEntities.BaseCucumberTest;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import services.WebDriverFactory;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @After
    public void tearDown(){
        //WebDriverFactory.getDriver().quit();
    }
}
