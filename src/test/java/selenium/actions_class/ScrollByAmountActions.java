package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import static selenium.utils.BrowserUtils.moveTo;

public class ScrollByAmountActions {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();

    }

    @Test
    public void scrollPage() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
        WebElement flashingImage = driver.findElement(By.cssSelector("div[class='hover11 s__column']>div"));
//        Actions actions = new Actions(driver);
//        //actions.scrollByAmount(0,3000).perform();
//        actions.scrollToElement(flashingImage).scrollByAmount(0,200).perform();
        BrowserUtils.scrollByAmount(driver, 0, 3000);
        Thread.sleep(2000);
        // actions.moveToElement(flashingImage).perform();
        BrowserUtils.scrollToElement(driver, flashingImage);
        moveTo(driver, flashingImage);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
