package selenium.com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.DriverHelper;

public class blazeBase {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver= DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
