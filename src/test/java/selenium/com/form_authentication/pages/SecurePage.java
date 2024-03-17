package selenium.com.form_authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium.utils.BrowserUtils;

public class SecurePage {
    public SecurePage (WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//h2")
    WebElement header;
    public void validateHeader(WebDriver driver){
        String expectedHeader= "Secure Area";
        String actual = header.getText();
        Assert.assertEquals(expectedHeader,actual);
        System.out.println(header.getText());
    }
    @FindBy(css = "i[class='icon-2x icon-signout']")
    WebElement logoutBtn;
    public void setLogoutBtn(){
        logoutBtn.click();
    }
}
