package selenium.com.sauce_labs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.sauce_labs.pages.LoginPage;

public class SauceLabScripts extends SauceBase{
    @DataProvider(name = "dataForSauceLab")
    public Object[][]getData(){
        return new Object[][]{
                {"test","1234","Epic sadface: Username and password do not match any user in this service"},
                {"ganbaa","12w1w","Epic sadface: Username and password do not match any user in this service"},
                {"gadsa","12de343","Epic sadface: Username and password do not match any user in this service"},
                {"aasdf","      ","Epic sadface: Username and password do not match any user in this service"}

        };
    }

    @Test (dataProvider = "dataForSauceLab")
    public void testLoginFunction(String username,String password,String errorMessage){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(username,password);
        String actualErrorMsg = loginPage.errorMsg();
        //String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualErrorMsg,errorMessage);
        // DataProvider - provided be TestNG
    }
}
