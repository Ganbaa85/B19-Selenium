package selenium.com.sauce_labs.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

public class SauceBase {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver = DriverHelper.getDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
