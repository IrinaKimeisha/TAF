import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryDivTest extends BaseTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTestDivInt() {
        if (attempt == 5) {
            Assert.assertEquals(calculator.div(10, 2), 5);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }

}
