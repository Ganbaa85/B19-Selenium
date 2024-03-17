package selenium.alert_interface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;

public class Alert_Practice {
    WebDriver driver;

    @BeforeMethod
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("driver has initialized");

    }

    @Test
    public void popUpTask() throws InterruptedException {
        WebElement first = driver.findElement(By.xpath("//h5[contains(.,'Normal alert')]//following-sibling::button"));
        first.click();
        Thread.sleep(2000);

        String actual = BrowserUtils.alertGetText(driver);
        String expected = "Oops, something went wrong!";
        Assert.assertEquals(actual, expected);
        BrowserUtils.acceptAlert(driver);
        WebElement second = driver.findElement(By.xpath("//h5[contains(.,'SweetAlert')]//following-sibling::button"));
        second.click();
        Thread.sleep(3000);
        WebElement popButton = driver.findElement(By.xpath("//div[@class='swal-modal']//div[contains(.,'Something went wrong!')]"));
        Assert.assertEquals(BrowserUtils.getText(popButton),"Something went wrong!","Failed to validate");
        String actual2 = popButton.getText();
        String expected2 = "Something went wrong!";
        Assert.assertEquals(actual2, expected2);
        WebElement okBtn = driver.findElement(By.xpath("//button[.='OK']"));
        okBtn.click();


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
        System.out.println("Test is successful");
    }
}
