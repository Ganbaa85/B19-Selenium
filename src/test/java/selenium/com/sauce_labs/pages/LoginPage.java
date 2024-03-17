package selenium.com.sauce_labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.BrowserUtils;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id='user-name']")
    WebElement userName;
    @FindBy(css = "input[id='password']")
    WebElement password;
    @FindBy(css = "input[id='login-button']")
    WebElement loginButton;
    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public void loginFunctionality(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();

    }

    public String errorMsg() {
        return BrowserUtils.getText(errorMessage);
    }
}
