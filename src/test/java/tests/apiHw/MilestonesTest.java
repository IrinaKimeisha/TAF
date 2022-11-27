package tests.apiHw;

import baseEntities.BaseApiTest;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EndpointsForMilestone;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


import static io.restassured.RestAssured.given;

public class MilestonesTest extends BaseApiTest {
    private int projectID = 2;
    private int milestoneID = 2;

    //переделать что-то не идет

    @Test
    public void getMilestones1() {
        Milestone milestone = Milestone.builder()
                .name("Milestone1")
                .description("description")
                .is_started(true)
                .build();
        given()
                .when()
                .get(EndpointsForMilestone.GET_MILESTONES + projectID)
                .then()
                .log().body()
                .body("get(0).name", is(milestone.getName()))
                .body("get(0).description", equalTo(milestone.getDescription()))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getMilestones2() {
        //в конце {project_id} = 2
        String endpoint = "/index.php?/api/v2/get_milestones/" + projectID;

        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, endpoint);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        System.out.println(response.getBody().asPrettyString());

    }

    @Test
    public void getMilestones3() {
        String endpoint = "/index.php?/api/v2/get_milestones/" + projectID;
        given()
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addMilestone() {
        String endpoint = "/index.php?/api/v2/add_milestone/" + projectID;

        Milestone newMilestone = Milestone.builder()
                .name("MilestonesTheThird")
                .description("Some description of the third Milestone")
                .due_on(1669633191)
                .is_started(true)
                .build();
        given()
                .body(String.format("{\n" +
                                "  \"name\": \"%s\",\n" +
                                "  \"description\": \"%s\",\n" +
                                "  \"due_on\": %d,\n" +
                                "  \"is_started\" : %b\n" +
                                "}",
                        newMilestone.getName(),
                        newMilestone.getDescription(),
                        newMilestone.getDue_on(),
                        newMilestone.is_started()
                ))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        String endpoint = "/index.php?/api/v2/update_milestone/{milestone_id}";

        Milestone newMilestone = Milestone.builder()
                .name("OneMoreMilestone")
                .description("this is a description")
                .is_started(true)
                .due_on(1669805991)
                .build();
        given()
                .pathParam("milestone_id", milestoneID)
                .body(newMilestone, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void deleteMilestone() {

        given()
                .when()
                .pathParam("milestone_id", 2)
                .post(EndpointsForMilestone.DELETE_MILESTONES)
                .then()
                .log().status()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


}
