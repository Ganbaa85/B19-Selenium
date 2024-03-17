package selenium.com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class LumaProductList {
    public LumaProductList(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Driven Backpack']")
    WebElement drivenBackpack;
    @FindBy(xpath = "//a[contains(.,'Driven Backpack')]//..//following-sibling::div//form//following-sibling::button")
    WebElement addToCartBtn;
    @FindBy(className = "//a[.='shopping cart']")
    WebElement cartLink;
    @FindBy(css = "//span[.='Proceed to Checkout']")
    WebElement proceedAToCheckOut;
    public void hoverOverClick(WebDriver driver) throws InterruptedException {
        BrowserUtils.moveTo(driver,drivenBackpack);
        Thread.sleep(1000);
        addToCartBtn.click();
        Thread.sleep(1000);
        cartLink.click();
        proceedAToCheckOut.click();
        //checkOutLink.click();
    }


}
