package selenium.data_provider;

import org.testng.annotations.DataProvider;

public class DataProviderSeparated {
    @DataProvider(name = "myData")
    public Object[][] getData() {
        return new Object[][]{
                {"Ganbaa", "Aidar"},
                {"John", "Ibragim"},
                {"Tom", "Shelby"}
                // APACHE POI --> you will be able to implement this method to read
                // data from excel sheet


        };

    }


}
