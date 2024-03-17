package selenium.com.form_authentication.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class MainPage {
    public MainPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Form Authentication")
    WebElement form_auth;
    public void clickFormAuth(WebDriver driver){
        form_auth.click();

    }
}
