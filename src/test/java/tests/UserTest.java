package tests;

import configuration.ReadProperties;
import models.User;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void UserTest() {
        User user = new User.Builder()
                .withName(ReadProperties.username())
                .withPassword(ReadProperties.password())
                .build();
    }
}
