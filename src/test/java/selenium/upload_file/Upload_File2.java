package selenium.upload_file;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

import java.time.Duration;

public class Upload_File2 {
    WebDriver driver = DriverHelper.getDriver();

    @BeforeMethod
    public void initializeDriver() {

        driver.get(ConfigReader.readProperty("techURL"));


    }

    @Test
    public void uploadFile2() throws InterruptedException {
        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Ganbaa");
        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Jargal");
        WebElement genderButton = driver.findElement(By.cssSelector("input[id='sex-0']"));
        genderButton.click();
        WebElement experienceButton = driver.findElement(By.cssSelector("input[id='exp-6']"));
        experienceButton.click();
        WebElement date = driver.findElement(By.cssSelector("input[id='datepicker']"));
        date.sendKeys("01/01/2024");
        WebElement profession = driver.findElement(By.cssSelector("input[id='profession-1']"));
        profession.click();
        WebElement toolPick = driver.findElement(By.cssSelector("input[id='tool-2']"));
        toolPick.click();
        Thread.sleep(4000);
        WebElement country = driver.findElement(By.cssSelector("select[id='continents']"));
        Select select = new Select(country);
        select.selectByVisibleText("North America");


        WebElement uploadButton = driver.findElement(By.cssSelector("input[class='input-file']"));
        uploadButton.sendKeys("/Users/ganbaatarjargal/IdeaProjects/B19-Selenium/src/test/resources/testData/Cartoon image.jpeg");


        WebElement submit = driver.findElement(By.cssSelector("button[id='submit']"));
        submit.click();


    }

    @Test
    public void validateTitleHeaders() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.techlistic.com/p/selenium-practice-form.html";
        Assert.assertEquals(actualURL, expectedURL);
        WebElement header1 = driver.findElement(By.xpath("//h3[.='Demo Automation Practice Form']"));
        WebElement header2 = driver.findElement(By.xpath("//h2[.='AUTOMATION PRACTICE FORM']"));
        Assert.assertEquals(BrowserUtils.getText(header1), "Demo Automation Practice Form");
        Assert.assertEquals(BrowserUtils.getText(header2), "AUTOMATION PRACTICE FORM");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
        System.out.println("Test finished");

    }
}
