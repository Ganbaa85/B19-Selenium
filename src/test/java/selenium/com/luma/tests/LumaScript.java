package selenium.com.luma.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.com.luma.pages.LumaMain;
import selenium.com.luma.pages.LumaProductList;
import selenium.com.luma.pages.LumuCheckOut;
import selenium.utils.BrowserUtils;

public class LumaScript extends LumaBase {
    @Parameters ({"email","firstName","lastName","streetName","city","zipcode","telephone"})
    @Test
    public void validatePurchase(String email,String firstName,String lastName,String streerName,String city,String zipcode,String telephone) throws InterruptedException {
        LumaMain lumaMain = new LumaMain(driver);

        BrowserUtils.moveTo(driver, lumaMain.hoverOverGear());
        Thread.sleep(3000);
        lumaMain.clickOnBags().click();

        LumaProductList productList = new LumaProductList(driver);
        productList.hoverOverClick(driver);
        LumuCheckOut checkOut = new LumuCheckOut(driver);
        checkOut.fillOutInfo(email,firstName,lastName,streerName,city,zipcode,telephone);

    }
}
