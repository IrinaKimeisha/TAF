package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;


public class BaseApiTest {
    protected DataBaseService dataBaseService;

    @BeforeTest
    public void setUpApi() {
        RestAssured.baseURI = "https://aqa2102.testrail.io";

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void tearDown() {
        dataBaseService.closeConnection();
    }
}
