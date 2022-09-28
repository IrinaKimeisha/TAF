import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Parameters({"login-value", "psw-value"})
    @Test
    public void paramTest(@Optional("Default login") String login, @Optional("111111") String psw) {
        System.out.println("Login is: " + login);
        System.out.println("Password is: " + psw);
    }
}
