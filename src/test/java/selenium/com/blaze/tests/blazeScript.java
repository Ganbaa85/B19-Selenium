package selenium.com.blaze.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.com.blaze.pages.BlazeMainPage;
import selenium.com.blaze.pages.CartPage;
import selenium.com.blaze.pages.LaptopPage;
import selenium.com.blaze.pages.ProductInfoPage;

public class blazeScript extends blazeBase{

    @Test(dataProvider = "MockData",dataProviderClass = BlazeTestData.class)
    public void clicking(String name,String country,String city,String cardNumber,String month,String year,String thanksmessage) throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        ProductInfoPage productInfoPage = new ProductInfoPage(driver);
        CartPage cartPage = new CartPage(driver);
        blazeMainPage.clickOnLaptop();

        laptopPage.clickMcBookPro();
        productInfoPage.addTocartButton(driver);
        cartPage.validateProductTableClickPlaceOrder();
        cartPage.fillingCustInfo(name, country, city, cardNumber, month, year,thanksmessage);



    }

}
