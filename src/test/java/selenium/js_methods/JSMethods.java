package selenium.js_methods;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

public class JSMethods {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();

    }

    @Test
    public void getTitleWithJavaScript() {
        driver.get("https://www.amazon.com/");
        // Casting our driver into JavaScriptExecuter
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " title from amazon using JS method");


    }

    @Test
    public void clickWithJavaScript() {
        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test
    public void scrollIntoView() {
        driver.get("https://codefish.io/");
        WebElement facebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", facebookLink);

    }

    @Test
    public void scrollWithPointJS() {
        // scrolling with is and Point class from selenium
        driver.get("https://the-internet.herokuapp.com/");
        WebElement footerLink = driver.findElement(By.linkText("Elemental Selenium"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = footerLink.getLocation();
        int x = point.getX(); // gets horizontal distance from edge of screen to Webelement
        int y = point.getY(); // get vertical distance from edge of the screen to Webelement
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
        System.out.println("x is " + x + " y is " + y);


    }

    @Test
    public void testJSMethods() throws InterruptedException {
        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", contactUs);
        Thread.sleep(2000);

        js.executeScript("arguments[0].click()", contactUs);
        Thread.sleep(2000);
        String contactUsTitle = js.executeScript("return document.title").toString();
        System.out.println(contactUsTitle);
        String expectedTitleContactUs = "Contact Us | Yale University";
        Assert.assertEquals(contactUsTitle, expectedTitleContactUs, "Failed to validate title");
        WebElement contactWebEditor = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));

        Point point = contactWebEditor.getLocation();
        int x = point.getX();
        int y = point.getY();
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
        js.executeScript("arguments[0].click()", contactWebEditor);
        Thread.sleep(2000);
        String titleWebEditor = js.executeScript("return document.title").toString();
        System.out.println(titleWebEditor);


    }

    @Test
    public void jsReusableTestMethods() throws InterruptedException {
        driver.get("https://www.yale.edu/");
        WebElement contactUs = driver.findElement(By.linkText("Contact Us"));
        BrowserUtils.scrollIntoViewJS(driver, contactUs);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, contactUs);
        Thread.sleep(2000);
        String contactUsTitle = BrowserUtils.getTitleWithJS(driver);
        System.out.println(contactUsTitle);
        String expectedTitleContactUs = "Contact Us | Yale University";
        Assert.assertEquals(contactUsTitle, expectedTitleContactUs, "Failed to validate title");
        WebElement contactWebEditor = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));
        BrowserUtils.scrollWithPointJS(driver, contactWebEditor);
        BrowserUtils.clickWithJS(driver, contactWebEditor);
        Thread.sleep(2000);
        String titleWebEditor = BrowserUtils.getTitleWithJS(driver);
        System.out.println(titleWebEditor);


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
