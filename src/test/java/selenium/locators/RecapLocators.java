package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecapLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        WebElement horizontalSlider = driver.findElement(By.linkText("Horizontal Slider"));
        horizontalSlider.click();
        Thread.sleep(2000);
        WebElement subHeader = driver.findElement(By.tagName("h4"));
        String actualSub = subHeader.getText();
        String expectedSub = "Set the focus on the slider (by clicking on it) and use the arrow keys to move it right and left. Or click and drag the " +
                "slider with your mouse. It will indicate the value of the slider to the right.";
        if (actualSub.equals(expectedSub)) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
        }
        WebElement partialLink = driver.findElement(By.partialLinkText("Elemental"));
        partialLink.click();


    }
}
