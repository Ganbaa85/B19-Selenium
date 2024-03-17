package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicsTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://codefish.io/");
        driver.manage().window().maximize();
        String actual = driver.getTitle();
        String expTitle = "CodeFish";
        if (actual.equals(expTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        Thread.sleep(8000);
        driver.manage().window().minimize();

        driver.quit();

    }
}
