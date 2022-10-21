package tests;

import org.testng.annotations.Test;

public class ParamTest {
    @Test
    public void paramTest(){
        System.out.println(System.getProperty("testProp"));
    }
}
