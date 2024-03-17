package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBasics {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/ganbaatarjargal/Desktop/Batch19%20hmtl/First%20Title.HTML");
        driver.manage().window().maximize();
        WebElement text = driver.findElement(By.tagName("h1")); // tagName
        String actualText = text.getText();
        String expectedText = "Love Coding";
        System.out.println(actualText);
        if (actualText.equals(expectedText)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        WebElement clickHereForHelpLink = driver.findElement(By.linkText("Click here for help"));
        clickHereForHelpLink.click();



    }
}
