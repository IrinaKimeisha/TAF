package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

   /* @DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };
    }*/
    @DataProvider (name = "dataForIntDiv")
    public static Object[][] dataForIntDivTest() {
        return new Object[][] {
                {-6, -3, 2},
                {0, 1, 0},
                {8, 2, 4}
        };
    }
    @DataProvider (name = "dataForDoubleDiv")
    public static Object[][] dataForDoubleDivTest() {
        return new Object[][] {
                {-6.0, -3.0, 2.0},
                {0, 1.0, 0},
                {8.0, 2.0, 4.0}
        };
    }

}
