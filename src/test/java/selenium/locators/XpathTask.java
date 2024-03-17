package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        driver.manage().window().maximize();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='name']"));
        inputName.sendKeys("Ganbaa");
        driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Apple");
        driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.apple.com");
        driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("New York");
        driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("2200 devon ave Chicago");
        driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("790 woodhollow Buffalo grove");
        driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Illinois");
        driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("60089");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();





    }
}
