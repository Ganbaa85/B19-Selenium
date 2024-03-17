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

public class ClickAndHold {
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void clickAndHold() {
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.cssSelector("div[id='draggable']~div[id='droppable']"));
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(draggable).moveToElement(droppable).release().perform();
        BrowserUtils.clickHoldAndDrop(driver,draggable,droppable);
        WebElement droppedMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertEquals(BrowserUtils.getText(droppedMessage), "Dropped!");
    }
    @Test
    public void twoDrops() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement acceptButton = driver.findElement(By.cssSelector("a[id='droppableExample-tab-accept']"));
        acceptButton.click();
        WebElement acceptable = driver.findElement(By.cssSelector("#acceptable"));
        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));
        WebElement dropArea = driver.findElement(By.xpath("//div[@id='acceptable']//..//following-sibling::div[@id='droppable']"));
        Thread.sleep(2000);
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(acceptable).moveToElement(dropArea).release().perform();
//        actions.clickAndHold(notAcceptable).moveToElement(dropArea).release().perform();
        BrowserUtils.clickHoldAndDrop(driver,acceptable,dropArea);
        BrowserUtils.clickHoldAndDrop(driver,notAcceptable,dropArea);
        WebElement droppedMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println(BrowserUtils.getText(droppedMessage));
        System.out.println(droppedMessage.getCssValue("font-family"));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
