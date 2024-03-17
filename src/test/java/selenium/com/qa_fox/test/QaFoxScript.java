package selenium.com.qa_fox.test;

import org.testng.annotations.Test;
import selenium.com.qa_fox.pages.ClientRegisterPage;
import selenium.com.qa_fox.pages.ProductListPage;
import selenium.com.qa_fox.pages.QaFoxMainPage;

public class QaFoxScript extends QaBase {


    @Test
    public void TC_01_PositiveScenario() throws InterruptedException {
        QaFoxMainPage mainPage= new QaFoxMainPage(driver);
        ProductListPage listPage = new ProductListPage(driver);

        mainPage.clickOnShowAllDesktops(driver);
        listPage.validateSorting();
    }

    @Test(dataProvider = "dataQa", dataProviderClass = DataQaFox.class)
    public void validateCustomerCreateProfile(String firstName, String lastName, String email, String telephone, String password) throws InterruptedException {

        QaFoxMainPage mainPage = new QaFoxMainPage(driver);
        mainPage.clickOnRegister(driver);



        ClientRegisterPage registerPage = new ClientRegisterPage(driver);
        registerPage.createCustomerProfile(firstName, lastName, email,
                telephone, password);

    }

    /*
    Navigate to main page of QA Fox
    1. Click on my account from mainPage
    2. Click on register link from mainPage
    3. On register age, fill in all required input fields (parametrize your data, no need to use
        dataProvider)
    4. Click 'yes' radio button
    5. Check checkBox for privacy
    6. Click Continue button

     */
}
