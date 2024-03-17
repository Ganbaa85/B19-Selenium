package selenium.com.yale.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

public class YaleBase {
    WebDriver driver;


    @BeforeMethod
    public void initializeDriver(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("yaleURl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        Thread.sleep(3000);
        if (!result.isSuccess()){
            BrowserUtils.takeScreenShot(driver);
        }
        driver.quit();
    }
}
