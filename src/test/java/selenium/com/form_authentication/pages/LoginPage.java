package selenium.com.form_authentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public LoginPage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }
   @FindBy(css = "input[id='username']")
    WebElement username;
   @FindBy(css = "input[id='password']")
    WebElement password;
   @FindBy(css = "button[type='submit']")
    WebElement loginButton;
   public void loginFunctionality(){
       this.username.sendKeys("tomsmith");
       this.password.sendKeys("SuperSecretPassword!");

   }
   public void clickLogin(){
       loginButton.click();
   }
}
