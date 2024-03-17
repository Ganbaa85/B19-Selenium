package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsHomePractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/ganbaatarjargal/Desktop/Batch19%20hmtl/InputForms.html");
        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Ganbaa");
        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Jargal");
        WebElement birthDay = driver.findElement(By.name("bdate"));
        birthDay.sendKeys("-07291985");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("ganbaa@yahoo.com");
        driver.findElement(By.name("quantity")).sendKeys("10000");
        driver.findElement(By.id("Mrs.")).click();
        driver.findElement(By.id("subscribe")).click();
        driver.findElement(By.name("country")).sendKeys("USA");
        driver.findElement(By.name("state")).sendKeys("Buffalo Grove");
        driver.findElement(By.tagName("textarea")).sendKeys("Love selenium" + Keys.ENTER + Keys.ENTER + "hello");



    }
}
