package selenium.com.blaze.tests;

import org.testng.annotations.DataProvider;

public class BlazeTestData {
    @DataProvider(name = "MockData")
    public Object[][]getDate(){
        return new Object[][]{
                {"John Wick","Usa","New york","9999999","9","2024","Thank you for your purchase!"}
        };

    }


}
