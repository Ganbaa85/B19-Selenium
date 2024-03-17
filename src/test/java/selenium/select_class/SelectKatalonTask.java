package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectKatalonTask {
    @Test
    public void validateAppointmeentFunctionality() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        WebElement element = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        Select select = new Select(element);
        select.selectByVisibleText("Seoul CURA Healthcare Center");
        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        driver.findElement(By.xpath("//input[@id='radio_program_none']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("01/01/2024");
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("hello");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        Thread.sleep(5000);
        WebElement confirmedText = driver.findElement(By.tagName("h2"));
        String actual = confirmedText.getText();
        String expectedText = "Appointment Confirmation";

        Assert.assertEquals(actual, expectedText, "Failed to validate");
        WebElement clientComment = driver.findElement(By.id("comment"));
        String actualComment = clientComment.getText();
        String expectedComment = "hello";
        Assert.assertEquals(actualComment, expectedComment, "Failed to validate comment");

        driver.findElement(By.xpath("//a[contains(.,'Go to Homepage')]")).click();


    }
}
