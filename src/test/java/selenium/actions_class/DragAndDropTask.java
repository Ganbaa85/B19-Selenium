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

public class DragAndDropTask {
    WebDriver driver;
    @BeforeMethod
    public void navigateTo(){
        driver = DriverHelper.getDriver();

    }
    @Test
    public void dragDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement dot = driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement orange = driver.findElement(By.cssSelector("div[class='test2']"));

        Actions actions = new Actions(driver);
        //actions.dragAndDrop(dot,orange).perform();
        actions.clickAndHold(dot).moveToElement(orange).release().perform();
        Thread.sleep(1000);
        orange = driver.findElement(By.cssSelector("div[class='test2']"));
        System.out.println(BrowserUtils.getText(orange));
        System.out.println(orange.getCssValue("background-color"));
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
