package selenium.com.php.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.DriverHelper;

public class PhpBase {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver= DriverHelper.getDriver();
        driver.get("https://phptravels.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
