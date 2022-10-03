import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivParamTest  {
    @Parameters({"numberA", "numberB"})
    @Test
    public void divParamTest(@Optional("numberA") String numberA, @Optional("numberB") String numberB){
        System.out.println("Dividing numberA by numberB is: " + Integer.parseInt(numberA) / Integer.parseInt(numberB));
    }
}
