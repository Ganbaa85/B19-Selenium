package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOver {

    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allUsers = driver.findElements(By.xpath("//div[@class='figure']"));
        List<WebElement> allUserNames = driver.findElements(By.xpath("//h5"));
        List<String> allTestNames = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Actions actions = new Actions(driver);
        for (int i = 0; i < allUsers.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(allUsers.get(i)).perform();

            allTestNames.add(allUserNames.get(i).getText());
            map.put(allUserNames.get(i).getText(), 1);
            if (!map.containsKey(allUserNames.get(i).getText())) {
                map.put(allUserNames.get(i).getText(), 1);
            } else {
                int value = map.get(allUserNames.get(i).getText());
                map.put(allUserNames.get(i).getText(), value + 1);
            }

        }
        System.out.println(allTestNames);
        System.out.println(map);


    }
    @Test
    public void hoverOverTask() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> price = driver.findElements(By.cssSelector("//div[@class='product k-listview-item']//p"));
        Map<String,String> productInfo = new HashMap<>();
        Actions actions = new Actions(driver);
        for (int i = 0; i < images.size(); i++) {
            Thread.sleep(400);
            actions.moveToElement(images.get(i)).perform();
            productInfo.put(names.get(i).getText(), price.get(i).getText());


        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
