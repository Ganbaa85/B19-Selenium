package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectPractice {
    @Test
    public void SelectTask() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        List<WebElement> allElements = driver.findElements(By.xpath("//a"));
        for (int i = 1; i < allElements.size(); i++) {
            if (allElements.get(i).getText().equals("Dropdown")) {
                allElements.get(i).click();
                break;
            }

        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to validate");
        WebElement header = driver.findElement(By.tagName("h3"));
        String actualHeader = header.getText();
        String expectedHeader = "Dropdown List";
        Assert.assertEquals(actualHeader, expectedHeader, "failed to validate header");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdown);
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> selectOptions = select.getOptions();
        for (WebElement eachElementFromListOfWebelement:selectOptions) {
            System.out.println(eachElementFromListOfWebelement.getText());
            if (eachElementFromListOfWebelement.getText().equals("Option 2")){
                eachElementFromListOfWebelement.click();
            }
        }

        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");


    }

}
