package selenium.com.qa_fox.test;

import org.testng.annotations.DataProvider;

public class DataQaFox {

    @DataProvider(name = "dataQa")
    public Object[][]getData(){

        return new Object[][]{
                {"Kobe","Abdy","email@test.com","3123232332","password"},
                {"Thomas","Shelby","thomas@test.com","3123232332","password"},
                {"Loki","Test","loki@test.com","3123232332","password"}

        };

    }
}
