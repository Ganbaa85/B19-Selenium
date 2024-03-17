package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class DragAndDrop {
    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[.='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[.='Draggable 2']"));
        WebElement dropZone = driver.findElement(By.cssSelector("div[id='mydropzone']"));
//        Actions actions = new Actions(driver);
//        actions.dragAndDrop(draggable1, dropZone).perform();
//        actions.dragAndDrop(draggable2, dropZone).perform();
        BrowserUtils.clickHoldAndDrop(driver,draggable1,dropZone);
        BrowserUtils.clickHoldAndDrop(driver,draggable2,dropZone);
        WebElement droppedList = driver.findElement(By.cssSelector("#droppedlist"));
        System.out.println(BrowserUtils.getText(droppedList));
        System.out.println(droppedList.getCssValue("visibility"));

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropMe = driver.findElement(By.xpath("//div[@id='droppable']"));
       // actions.dragAndDrop(dragMe,dropMe).perform();
        BrowserUtils.clickHoldAndDrop(driver,dragMe,dropMe);
        WebElement dropList2 = driver.findElement(By.cssSelector("#droppable"));
        System.out.println(BrowserUtils.getText(dropList2));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
