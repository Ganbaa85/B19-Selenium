package selenium.soft_assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import selenium.utils.DriverHelper;

public class SoftAssertShowCase {
    WebDriver driver;
    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();

    }



}
