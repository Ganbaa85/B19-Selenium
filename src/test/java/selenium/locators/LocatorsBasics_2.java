package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBasics_2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/ganbaatarjargal/Desktop/Batch19%20hmtl/InputForms.html");
        WebElement firstName=driver.findElement(By.id("fname"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Wick");
        WebElement bdate = driver.findElement(By.id("bdate"));
        bdate.sendKeys("01/01/2000");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("codefish@code.com");
        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.sendKeys("4");
        WebElement title = driver.findElement(By.id("Mr."));
        title.click();
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Buffalo Grove");
        WebElement text = driver.findElement(By.tagName("textarea"));
        text.sendKeys("hello world");
        WebElement partailLink = driver.findElement(By.partialLinkText("click"));
        partailLink.click();
        WebElement country = driver.findElement(By.name("country"));
        country.sendKeys("Japan");


    }
}
