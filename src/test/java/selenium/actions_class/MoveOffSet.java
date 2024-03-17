package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.List;

public class MoveOffSet {
    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void moveByOffSet() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(35, 0).perform();
    }
    @Test
    public void moveSliderWithActionsTask() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        Actions actions = new Actions(driver);
        List<WebElement> allSliders = driver.findElements(By.cssSelector("input[class='sp__range']"));
        List<WebElement> allText = driver.findElements(By.xpath("//output"));
        for (int i = 0; i < allSliders.size(); i++) {
            actions.clickAndHold(allSliders.get(i)).moveByOffset(99,0).perform();
            Thread.sleep(500);
            if (allText.get(i).getText().equalsIgnoreCase("80")){
                actions.clickAndHold(allSliders.get(i)).moveByOffset(-99,0).perform();

            }else {
                actions.clickAndHold(allSliders.get(i)).moveByOffset(99,0).perform();
            }


        }

    }
    @Test
    public void moveByOffSetPractice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropMe = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(200);
            actions.clickAndHold(dragMe).moveByOffset(100,-70).release().perform();
        }


    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        if (!result.isSuccess()){
            BrowserUtils.takeScreenShot(driver);
        }
//        Thread.sleep(3000);
//
//        driver.quit();

    }
}
