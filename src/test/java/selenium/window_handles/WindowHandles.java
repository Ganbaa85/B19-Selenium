package selenium.window_handles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.Set;

public class WindowHandles {
    WebDriver driver;
    @BeforeMethod
    public void initialize(){
        driver= DriverHelper.getDriver();
    }
    @Test
    public void testWindowSwitch(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement element = driver.findElement(By.linkText("Click Here"));
        BrowserUtils.clickWithJS(driver,element);
        String mainPageId = driver.getWindowHandle();
        Set<String> allWindowIds = driver.getWindowHandles();

        for (String singleWindow:allWindowIds){
            if (!singleWindow.equals(mainPageId)){
                driver.switchTo().window(singleWindow);
                break;
            }
        }

        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(newWindowText));

    }

    @Test
    public void windowSwitchPractice() throws InterruptedException {
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement openNewTab = driver.findElement(By.id("newTabBtn"));
        BrowserUtils.scrollWithPointJS(driver,openNewTab);
        BrowserUtils.clickWithJS(driver,openNewTab);
        String mainPageID = driver.getWindowHandle();
        Set<String> allIDs = driver.getWindowHandles();
        for (String id:allIDs){
            if (!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        Thread.sleep(2000);
        WebElement nextPageClickMe = driver.findElement(By.cssSelector("#alertBox"));
        BrowserUtils.scrollIntoViewJS(driver,nextPageClickMe);
        BrowserUtils.clickWithJS(driver,nextPageClickMe);
        Thread.sleep(2000);
        BrowserUtils.acceptAlert(driver);
    }
    @Test
    public void multipleWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
        WebElement facebook= driver.findElement(By.xpath("//a[contains(.,'Like us On Facebook')]"));
        facebook.click();
        WebElement twitter= driver.findElement(By.xpath("//a[contains(.,'Follow On Twitter')]"));
        twitter.click();
        WebElement linkedIn= driver.findElement(By.xpath("//a[contains(.,'Follow us On Linkedin')]"));
        linkedIn.click();
        String mainPageId = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String title = driver.getTitle();
        String expectedTitle = "LambdaTest | San Francisco CA | Facebook";
        for (String id:windowHandles) {
            Thread.sleep(2000);
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }
            Thread.sleep(2000);
            System.out.println(driver.getTitle());

        }


    }




    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
