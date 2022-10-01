import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BaseTest {
    @Test
    public void divInt() {
        Assert.assertEquals(calculator.div(10, 5), 2, "Неверное деление...");
    }

    @Test
    public void divDouble() {
        Assert.assertEquals(calculator.div(10.0, 5.0), 2.0, "Неверное деление...");
    }

    @Test(enabled = false)
    public void divInt1() {
        Assert.assertEquals(calculator.div(10, 2), 1, "Неверное деление...");
    }

    @Test(enabled = false)
    public void divDouble1() {
        Assert.assertEquals(calculator.div(10.0, 2.0), 1.0, "Неверное деление...");
    }
    @Test(timeOut = 1000)
    public void divIntTimeOut() throws InterruptedException {
        Thread.sleep(900);
        Assert.assertEquals(calculator.div(10, 2), 5, "Неверное деление...");
    }
    @Test(timeOut = 1000)
    public void divDoubleTimeOut() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(10.0, 2.0), 5.0, "Неверное деление...");
    }





}
