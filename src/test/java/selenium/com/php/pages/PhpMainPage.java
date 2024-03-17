package selenium.com.php.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhpMainPage {

    @FindBy(xpath = "//li//a[@href='https://phptravels.com/demo']")
    WebElement loginBtn;
    public void clickOnDemo(){
        loginBtn.click();
    }

}
