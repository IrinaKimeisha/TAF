package steps;

import models.Project;

public class ProjectsStep {
    public void createProject(String name, String description,
                              int type, boolean showAnon){

        System.out.println(name);
        System.out.println(description);
        System.out.println(type);
        System.out.println(showAnon);

    }

    public void createProject(Project project) {

        System.out.println(project.getName());
        System.out.println(project.getDescription());
        System.out.println(project.getType());
        System.out.println(project.isShowAnon());

    }
}
