package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.List;

public class EnabledDisabledField {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
        driver.get("https://formy-project.herokuapp.com/enabled");
    }

    @Test
    public void DisabledInput() {
        // WebElement disabled = driver.findElement(By.cssSelector("input[id='disabledInput']"));
        //disabled.sendKeys("hello");
        List<WebElement> enabledDisabled = driver.findElements(By.cssSelector(".form-control"));
        for (WebElement element : enabledDisabled) {
            if (element.isEnabled()) {
                element.sendKeys("test");
            }
        }


    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        if (!result.isSuccess()){
            BrowserUtils.takeScreenShot(driver);

        }
        Thread.sleep(2000);
        driver.quit();
    }


}