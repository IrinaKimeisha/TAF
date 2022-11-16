package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestRailApiTest2 extends BaseApiTest {
    @Test
    public void getAllUsers() {
        User user = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko+aqa21@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        given()
                .when()
                .get(Endpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .body("get(0).name", is(user.getName()))
                .body("get(0).email", equalTo(user.getEmail()))
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getUser() {
        int userID = 1;

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko+aqa21@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        User actualUser = given()
                .pathParam("id", userID)
                .get(Endpoints.GET_USER)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(User.class);

        System.out.println(actualUser.toString());
        System.out.println(expectedUser.toString());

        Assert.assertTrue(actualUser.equals(expectedUser));
    }

    @Test
    public void getUser1() {
        int userID = 1;
        Gson gson = new Gson();

        User expectedUser = User.builder()
                .name("Aleksandr Trostyanko")
                .email("atrostyanko+aqa21@gmail.com")
                .isActive(true)
                .roleId(1)
                .role("Lead")
                .build();

        Response response = given()
                .pathParam("id", userID)
                .get(Endpoints.GET_USER);

        User actualUser = gson.fromJson(response.getBody().asString(), User.class);

        Assert.assertEquals(actualUser, expectedUser);
    }
}
