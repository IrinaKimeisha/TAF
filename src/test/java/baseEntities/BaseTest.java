package baseEntities;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                //.screenshots(true) //снимать или нет скриншот, если не надо, то false
                //.savePageSource(true) //если ошибка, то сохр текущей доммодели

        );
        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        //open("");
        Configuration.timeout = 8000;
        Configuration.fastSetValue = true;
        //Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.headless = true;
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}

