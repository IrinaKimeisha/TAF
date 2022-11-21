package tests.DB;

import org.testng.annotations.Test;
import services.DataBaseService;

public class SimpleDBTest {
    @Test
    public void simpleDBTest(){
        DataBaseService dataBaseService= new DataBaseService();
    }
}
