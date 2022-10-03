import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BaseTest {
    @Test
    public void divIntTest() {
        Assert.assertEquals(calculator.div(10, 5), 2, "Неверное деление...");
    }

    @Test
    public void divDoubleTest() {
        Assert.assertEquals(calculator.div(10.0, 5.0), 2.0, "Неверное деление...");
    }

    @Test(enabled = false)
    public void divIntTest1() {
        Assert.assertEquals(calculator.div(10, 2), 5, "Неверное деление...");
    }

    @Test(enabled = false)
    public void divDoubleTest1() {
        Assert.assertEquals(calculator.div(10.0, 2.0), 5.0, "Неверное деление...");
    }


    @Test(timeOut = 1000)
    public void divIntTimeOutTest() throws InterruptedException {
        Thread.sleep(900);
        Assert.assertEquals(calculator.div(10, 2), 5, "Неверное деление...");
    }

    @Test(timeOut = 1000)
    public void divDoubleTimeOutTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(10.0, 2.0), 5.0, "Неверное деление...");
    }

    @Test(invocationCount = 5, invocationTimeOut = 1000, threadPoolSize = 5)
    public void divIntInvocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(10, 2), 5, "Неверная деление...");
    }

    @Test(invocationCount = 2, invocationTimeOut = 1000, threadPoolSize = 2)
    public void divDoubleInvocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(10.0, 2.0), 5.0, "Неверная деление...");
    }

    @Test(dataProvider = "dataForIntDiv", dataProviderClass = StaticProvider.class)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверная деление...");
    }

    @Test(dataProvider = "dataForDoubleDiv", dataProviderClass = StaticProvider.class)
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверная деление...");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testExceptionsInt() {
        Assert.assertEquals(calculator.div(10, 0), 0);

    }
}
