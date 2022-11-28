package tests.apiHw;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Testcase;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EndpointsForTestCases;

import static io.restassured.RestAssured.given;

public class TestCaseTest extends BaseApiTest {
    private int testCaseId = 1;

    @Test
    public void getTestcase() {

        Response response = (Response) given()
                .pathParam("case_id", testCaseId)
                .get(EndpointsForTestCases.GET_TESTCASE)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Testcase.class);
    }

}
