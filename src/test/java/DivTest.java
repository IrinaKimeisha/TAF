import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends BaseTest {
    @Test(groups = "smoke", priority = 1)
    public void divIntTest() {
        Assert.assertEquals(calculator.div(10, 5), 2, "Неверное деление...");
    }

    @Test(groups = "regression", priority = 2)
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

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsIntBy0(){
        Assert.assertEquals(calculator.div(10, 0),0, "prohibited");
    }
    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsNegIntBy0(){
        Assert.assertEquals(calculator.div(-10, 0),0, "prohibited");
    }
    @Test(groups = "smoke")
    public void testExceptions0byInt(){
        Assert.assertEquals(calculator.div(0, 10), 0);
    }
    @Test(groups = "smoke")
    public void testExceptions0byNegInt(){
        Assert.assertEquals(calculator.div(0, -10), 0);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "smoke")
    public void testExceptionsInt0by0(){
        Assert.assertEquals(calculator.div(0, 0), 0, "но так нельзя");
    }
    @Test(groups = "smoke")
    public void testExceptionsDoubleBy0() throws ArithmeticException{
        Assert.assertEquals(calculator.div(10.0, 0.0), Double.POSITIVE_INFINITY);
    }
    @Test(groups = "smoke")
    public void testExceptionsNegDoubleBy0() throws ArithmeticException{
        Assert.assertEquals(calculator.div(-10.0, 0.0), Double.NEGATIVE_INFINITY);
    }
    @Test(groups = "smoke")
    public void testExceptionsDouble0by0() throws ArithmeticException{
        Assert.assertEquals(calculator.div(0.0, 0.0), Double.NaN);
    }
}
