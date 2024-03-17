package selenium.com.php.tests;

import org.testng.annotations.Test;
import selenium.com.php.pages.PhpLoginPage;
import selenium.com.php.pages.PhpMainPage;

public class PhpTest extends PhpBase{
    @Test
    public void validateInputFields(String firstName,String lastName,String businessName,String email){
        PhpMainPage mainPage = new PhpMainPage();
        PhpLoginPage loginPage = new PhpLoginPage(driver);
        mainPage.clickOnDemo();
        loginPage.fillingBlanks(firstName,lastName,businessName,email);

    }

}
