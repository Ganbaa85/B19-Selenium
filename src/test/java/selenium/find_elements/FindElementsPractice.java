package selenium.find_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FindElementsPractice {
    @Test(priority = 3)
    public void TC_01() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        List<String> alltext = new ArrayList<>();
//        for (int i = 1; i < allLinks.size(); i++) {
//            WebElement element = allLinks.get(i);
//            String str = element.getText();
//            int length = str.length();
//            if (length < 10) {
//                alltext.add(str);
//            }
//        }

        for (int i = 0; i < allLinks.size(); i++) {
            if (allLinks.get(i).getText().length() < 10) {
                alltext.add(allLinks.get(i).getText());

            }


        }
        System.out.println(alltext);


    }

    @Test(priority = 1)
    public void TC_02() {
        System.out.println("test 2");

    }

    @Test(priority = 2)
    public void TC_03() {
        System.out.println("test 3");
    }
}
