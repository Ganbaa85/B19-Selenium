package selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class NinjaTest {
    @Test
    public void ninjeTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ganbaatar");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Jargal");
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("test098765@test.com");
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='telephone']"));
        phoneNumber.sendKeys("777777777");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("password");
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@name='confirm']"));
        passwordConfirm.sendKeys("password");
        List<WebElement> newsLetter = driver.findElements(By.xpath("//label[@class='radio-inline']"));
        for (int i = 0; i < newsLetter.size(); i++) {
            if (BrowserUtils.getText(newsLetter.get(i)).equalsIgnoreCase("yes")) {
                newsLetter.get(i).click();
                break;
            }
        }
        WebElement agreeButton = driver.findElement(By.xpath("//input[@name='agree']"));
        if (!agreeButton.isSelected()) {
            agreeButton.click();
        }
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        Thread.sleep(5000);



    }
}
