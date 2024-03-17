package selenium.com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {
    public  LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement mcBookPro;
    public void clickMcBookPro() throws InterruptedException {
        mcBookPro.click();
        Thread.sleep(2000);

    }
}
