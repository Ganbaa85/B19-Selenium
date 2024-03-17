package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.utils.BrowserUtils;

public class XPathPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.manage().window().maximize();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='title']"));
        inputName.sendKeys("Ganbaa");
//        WebElement inputMessage = driver.findElement(By.xpath("//textarea[@name='description']"));
//        inputMessage.sendKeys("Hello");
        WebElement inputMessage = BrowserUtils.findElement(driver, By.xpath("//textarea[@name='description']"));
        inputMessage.sendKeys("Hello how are you");
        WebElement button = driver.findElement(By.xpath("//input[@type='button']"));
        button.click();
        WebElement subMissionMsg = driver.findElement(By.id("submit-control"));
        System.out.println(subMissionMsg.getText());


    }
}
