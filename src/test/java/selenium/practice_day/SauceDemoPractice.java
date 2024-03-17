package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.ConfigReader;
import selenium.utils.DriverHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SauceDemoPractice {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("input[id='user-name']"));
        username.sendKeys(ConfigReader.readProperty("username"));
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys(ConfigReader.readProperty("password"));
        WebElement button = driver.findElement(By.cssSelector("input[id='login-button']"));
        button.click();

    }

    @Test
    public void sauceDemoSorting() {

        List<WebElement> allprices = driver.findElements(By.cssSelector(".inventory_item_price"));
        WebElement sortDropdown = driver.findElement(By.cssSelector(".product_sort_container"));
        BrowserUtils.selectBy(sortDropdown, "Price (low to high)", "VisibleText");
        double[] actualprices = new double[allprices.size()]; // coming from website
        double[] sortedPrice = new double[allprices.size()]; // sorted here
        for (int i = 0; i < allprices.size(); i++) {
            actualprices[i] = Double.parseDouble(allprices.get(i).getText().replace("$", ""));
            sortedPrice[i] = Double.parseDouble(allprices.get(i).getText().replace("$", ""));
        }
        System.out.println(Arrays.toString(actualprices));
      //  System.out.println(Arrays.toString(sortedPrice));
        for (int i = 0; i < sortedPrice.length; i++) {
            double temp;
            for (int j = i + 1; j <sortedPrice.length; j++) {
                if (sortedPrice[i]>sortedPrice[j]){
                    temp=sortedPrice[i];
                    sortedPrice[i]=sortedPrice[j];
                    sortedPrice[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(sortedPrice));
    }

    @Test
    public void lockedOutUser(){
        WebElement lockedOutMessage = driver.findElement(By.cssSelector("h3[data-test]"));
        System.out.println(lockedOutMessage.getText());
        String actualText = BrowserUtils.getText(lockedOutMessage);
        String expectedText = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(actualText,expectedText,"Failed to validate error message");
    }









    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
