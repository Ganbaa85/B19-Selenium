package selenium.com.form_authentication.test;

import org.testng.annotations.Test;
import selenium.com.form_authentication.pages.LoginPage;
import selenium.com.form_authentication.pages.MainPage;
import selenium.com.form_authentication.pages.SecurePage;

public class Form_scripts extends FormBase {
    @Test
    public void clickOnMainPage() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFormAuth(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality();
        loginPage.clickLogin();
        SecurePage securePage = new SecurePage(driver);
        Thread.sleep(2000);
        securePage.validateHeader(driver);
        securePage.setLogoutBtn();
    }
}
