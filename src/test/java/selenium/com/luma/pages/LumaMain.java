package selenium.com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.com.blaze.pages.BlazeMainPage;
import selenium.utils.BrowserUtils;

import java.time.Duration;

public class LumaMain {
    WebDriver driver;
    public LumaMain(WebDriver driver){
        this.driver = driver;
    }
    private By gear = By.xpath("//a[@id='ui-id-6']");
    private By bags =By.xpath("//a[.='Bags']");

    public WebElement clickOnBags(){
        return driver.findElement(bags);


    }
    public   WebElement hoverOverGear(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(gear));
        return driver.findElement(gear);
    }


}
