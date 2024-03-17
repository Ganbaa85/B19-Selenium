package selenium.practice_day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;
import selenium.utils.DriverHelper;

import java.util.List;

public class Qafox_Project {
    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @Test
    public void ProductCheckOut() throws InterruptedException {
        WebElement desktop = driver.findElement(By.xpath("//a[contains(.,'Desktops')]"));
        BrowserUtils.moveTo(driver, desktop);
        WebElement showAllDesktop = driver.findElement(By.xpath("//a[contains(.,'Show AllDesktops')]"));
        showAllDesktop.click();
        WebElement addtoCart = driver.findElement(By.xpath("//h4//a[.='Sony VAIO']//..//..//following-sibling::div//span[.='Add to Cart']"));
        BrowserUtils.scrollToElement(driver, addtoCart);
        addtoCart.click();
        Thread.sleep(2000);
        WebElement shoppingcart = driver.findElement(By.xpath("//a[.='shopping cart']"));
        shoppingcart.click();
        WebElement checkout = driver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
        checkout.click();
        WebElement radioButton = driver.findElement(By.cssSelector("input[value='guest']"));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }


    }
}
