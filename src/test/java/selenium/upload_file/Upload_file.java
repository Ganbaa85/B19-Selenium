package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;

public class Upload_file {
    @Test
    public void TC_1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement fileUpload = driver.findElement(By.cssSelector("input[id='file-upload']"));
        fileUpload.sendKeys("/Users/ganbaatarjargal/IdeaProjects/B19-Selenium/src/test/resources/testData/Cartoon image.jpeg");
        Thread.sleep(3000);
        WebElement fileSubmitButton = driver.findElement(By.cssSelector("input[id='file-submit']"));
        fileSubmitButton.click();
        WebElement successMsg = driver.findElement(By.tagName("h3"));
        String actualSuccessMsg = BrowserUtils.getText(successMsg);
        String expectedMsg = "File Uploaded!";
        Assert.assertEquals(actualSuccessMsg,expectedMsg,"Failed to vaildate ");

        WebElement fileNameText = driver.findElement(By.cssSelector("div[id='uploaded-files']"));

        String actualFileName = BrowserUtils.getText(fileNameText);
        String expectedFileName = "Cartoon image.jpeg";
        Assert.assertEquals(actualFileName,expectedFileName,"Failed to validate file name");





    }
}
