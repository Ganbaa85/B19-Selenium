package selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;

public class TestDairy {
    @Test
    public void fillInInputField () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement checkBoxSelenium = driver.findElement(By.xpath("//input[@id='seleniumbox']"));
        WebElement checkBoxRestApi = driver.findElement(By.xpath("//input[@id='restapibox']"));
        if (checkBoxRestApi.isSelected()){
            checkBoxSelenium.click();
            checkBoxRestApi.click();
        }
        WebElement javaCheckBox = driver.findElement(By.xpath("//input[@id='java1']"));
        javaCheckBox.click();
        WebElement testDairyChoose = driver.findElement(By.xpath("//span[@style='color: #0000ff;']//a[@style='color: #0000ff;']"));
        testDairyChoose.getAttribute("Test Diary");
        testDairyChoose.click();

        WebElement testDairyText = driver.findElement(By.xpath("//h1[@itemprop='headline']"));
        System.out.println(testDairyText.getText());
        driver.navigate().back();
        WebElement TDSL = driver.findElement(By.linkText("Test Diary Selenium Learning"));
        TDSL.click();
        driver.navigate().back();
        WebElement dropDownShirt = driver.findElement(By.xpath("//select[@id='Shirts']"));
        WebElement dropDownSkirt = driver.findElement(By.cssSelector("select[id='Skirts']"));
        Select select = new Select(dropDownShirt);
        select.selectByVisibleText("Yellow Shirt");
        BrowserUtils.selectBy(dropDownSkirt,"Red Skirt","visibleText");
        WebElement contactFormFullName = driver.findElement(By.cssSelector("input[name='your-name']"));
        contactFormFullName.sendKeys("ganbaatar jargal");
        WebElement contactFormEmail = driver.findElement(By.cssSelector("input[name='your-email']"));
        contactFormEmail.sendKeys("test@test.com");
        WebElement contactFormSubject = driver.findElement(By.cssSelector("input[name='your-subject']"));
        contactFormSubject.sendKeys("hello");
        WebElement contactFormMessage = driver.findElement(By.cssSelector("textarea[name='your-message']"));
        contactFormMessage.sendKeys("i love java");
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        Thread.sleep(20000);
        WebElement successMessage = driver.findElement(By.xpath("//input[@type='submit']//..//following-sibling::div"));
        Assert.assertEquals(BrowserUtils.getText(successMessage), "Your message was sent successfully. Thanks.");
















    }
}
