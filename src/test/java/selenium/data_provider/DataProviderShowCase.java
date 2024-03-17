package selenium.data_provider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderShowCase {

    // this dataProvider can be also located fro diffrent class

//    @DataProvider(name = "myData")
//    public Object[][] getData() {
//        return new Object[][]{
//                {"Ganbaa", "Aidar"},
//                {"John", "Ibragim"},
//                {"Tom", "Shelby"}
//                // APACHE POI --> you will be able to implement this method to read
//                // data from excel sheet
//
//
//        };
//
//    }
    /*
    Frameworks - TDD - (Test Driven Development) basically TestNG framework
                 DDD - Data Driven Development
     */

    @Test(dataProvider = "myData",dataProviderClass = DataProviderSeparated.class)
    public void testDataProvider(String name1, String name2) {

        System.out.println(name1 +" "+ name2);
    }
}
