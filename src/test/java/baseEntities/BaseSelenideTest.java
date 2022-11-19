package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


public class BaseSelenideTest {

    @BeforeSuite
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = ReadProperties.timeout(); //в милисекундах, по умолч 4000
        Configuration.fastSetValue = true; // по умолч true, насколько быстро устанавливать знач в поле
        //Configuration.assertionMode = AssertionMode.SOFT; //проверки, идущие друг за другом все равно выполнятся
    }
    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
