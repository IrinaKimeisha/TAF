package tests;

import configuration.ReadProperties;
import models.User;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public void lombokTest(){
        User user = new User();
        user.setUsername(ReadProperties.username());
        user.setPassword(ReadProperties.password());
        user.setFirstName(ReadProperties.firstNAme());
        user.setLastName(ReadProperties.lastName());
        user.setZip(ReadProperties.zip());

        User problemUser = new User();
        problemUser.setUsername("problem_user");
        problemUser.setPassword(ReadProperties.password());
        problemUser.setFirstName(ReadProperties.firstNAme());
        problemUser.setLastName(ReadProperties.lastName());
        problemUser.setZip(ReadProperties.zip());

        User locked_out_user = new User();
        locked_out_user.setUsername("locked_out_user");
        locked_out_user.setPassword(ReadProperties.password());
        locked_out_user.setFirstName(ReadProperties.firstNAme());
        locked_out_user.setLastName(ReadProperties.lastName());
        locked_out_user.setZip(ReadProperties.zip());

        User performance_glitch_user = new User();
        performance_glitch_user.setUsername("performance_glitch_user");
        performance_glitch_user.setPassword(ReadProperties.password());
        performance_glitch_user.setFirstName(ReadProperties.firstNAme());
        performance_glitch_user.setLastName(ReadProperties.lastName());
        performance_glitch_user.setZip(ReadProperties.zip());

    }
}
