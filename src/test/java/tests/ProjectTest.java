package tests;

import models.Project;
import org.testng.annotations.Test;
import steps.ProjectsStep;

public class ProjectTest {
    ProjectsStep projectsStep = new ProjectsStep();

    @Test
    public void createProjectTest() {
        projectsStep.createProject("test1", "dhjsd", 1, true);

    }

    @Test
    public void updateProjectTest() {
        Project project = new Project();
        project.setName("Test2");
        project.setDescription();



    }
}
