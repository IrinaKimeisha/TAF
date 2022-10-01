import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivParamTest  {
    @Parameters({"numberA-equals", "numberB-equals"})
    @Test
    public void divParamTest(@Optional("Default numberA") String numberA, @Optional("numberB") String numberB){
      //  System.out.println("Dividing numberA by numberB is: " + int a / int b);
    }
}
