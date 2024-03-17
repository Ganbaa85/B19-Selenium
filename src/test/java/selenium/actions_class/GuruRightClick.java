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

public class GuruRightClick {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver= DriverHelper.getDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

    }
    @Test
    public void rightClick() throws InterruptedException {
        WebElement rClick= driver.findElement(By.xpath("//span[.='right click me']"));
        // right click
        Actions actions = new Actions(driver);
        actions.contextClick(rClick).perform();
        Thread.sleep(2000);
        WebElement delete = driver.findElement(By.xpath("//span[.='Delete']"));
        delete.click();
        Thread.sleep(2000);
        String alertText = BrowserUtils.alertGetText(driver);
        System.out.println(alertText);
        BrowserUtils.acceptAlert(driver);
    }
    @Test
    public void doubleClick() throws InterruptedException {
        WebElement doubleClick= driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).build().perform();
        Thread.sleep(2000);
        System.out.println("BrowserUtils.alertGetText(driver) = " + BrowserUtils.alertGetText(driver));
        BrowserUtils.acceptAlert(driver);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
