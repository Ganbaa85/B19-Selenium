package selenium.get_attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Get_Attribute {
    @Test
    public void TC_1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button")).click();
        List<WebElement> allCheckbox = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement checkBox:allCheckbox
             ) {
            if (checkBox.getAttribute("aria-checked").equals("false")){
                checkBox.click();
            }

        }





    }
    @Test
    public void getAttribute(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button")).click();
        List<WebElement> allCheckbox = driver.findElements(By.xpath("//div[@role='checkbox']"));
        for (WebElement checkBox:allCheckbox) {
           String attribue = checkBox.getAttribute("aria-checked");
            System.out.println(attribue);


        }




    }
}
