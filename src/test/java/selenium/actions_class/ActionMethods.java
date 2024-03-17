package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.DriverHelper;

import javax.swing.*;

public class ActionMethods {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void contextClick(){
        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();
        WebElement hotSpot = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform(); // we must have (perform();) method
    }
//    public void rightClick(){
//
//    }
}
