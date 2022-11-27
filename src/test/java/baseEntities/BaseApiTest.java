package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;


public class BaseApiTest {

    @BeforeTest
    public void setUpApi() {
        //настройка базового uri
        RestAssured.baseURI = "https://aqa21022.testrail.io";

        //Настройка авторизации на сайт, бывает базовая и примитивная базовая, пробовать их, какая-то да подойдет ☺
        //не забывать про content_type!, некотрые сайты просят
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
    }
}
