package selenium.xpath_relationships;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XpathRelationsTask {
    @Test
    public void CodeFish() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allTexts = driver.findElements(By.xpath("//div[@class='gradient-block']//p"));

        for (int i = 0; i < allTexts.size(); i++) {
            Assert.assertTrue(allTexts.get(i).isDisplayed(), "Its not displayed");
            System.out.println(allTexts.get(i).getText());

        }


    }

    @Test
    public void TC_2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> firstName = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> emails = driver.findElements(By.xpath("//tr//td[4]"));
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < firstName.size(); i++) {
            String name = firstName.get(i).getText();
            String mail = emails.get(i).getText();
            data.put(name, mail);


        }
        System.out.print(data);
    }

    @Test
    public void TC_3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement rows = driver.findElement(By.id("maxRows"));
        Select select = new Select(rows);
        select.selectByVisibleText("Show ALL Rows");
        List<WebElement> firstName = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> lastName = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> email = driver.findElements(By.xpath("//tr//td[4]"));
        Map<String, String> namesAndEmails = new HashMap<>();
        for (int i = 0; i < lastName.size(); i++) {
            namesAndEmails.put(firstName.get(i).getText()+" "+lastName.get(i).getText()," " + email.get(i).getText());
        }
        System.out.println(namesAndEmails);

    }


}
