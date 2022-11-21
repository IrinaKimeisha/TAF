package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import models.User;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {

    public Project add(Project newProject) {
        return given()
                .body(newProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response()
                .as(Project.class, ObjectMapperType.GSON);
    }

    public Response getResponseAfterAdding(Project newProject) {
        return given()
                .body(newProject, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(Endpoints.ADD_PROJECT);
    }

    public Project[] getAllProjects() {
        Response response = given()
                .get(Endpoints.GET_ALL_PROJECTS);

        return gson.fromJson(response.getBody().asString(), Project[].class);
    }

    public void getProject() {

    }


}
