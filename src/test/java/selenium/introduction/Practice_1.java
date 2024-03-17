package selenium.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        String title = driver.getTitle();
        String expected =("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos");
        if (title.equals(expected)){
            System.out.println("Pass ");
        }else {
            System.out.println("fail");
        }
        driver.navigate().to("https://www.yahoo.com/");
        driver.manage().window().maximize();
        String pageSource = driver.getPageSource();

        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(3000);
        WebElement text = driver.findElement(By.linkText("path fill"));
        System.out.println(text.getText());




    }
}
