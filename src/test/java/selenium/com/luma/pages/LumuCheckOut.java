package selenium.com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import selenium.utils.BrowserUtils;

import java.util.List;

public class LumuCheckOut {
    public LumuCheckOut(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "fieldset>div>div>input[type='email']")
    WebElement email;
    @FindBy(css = "input[name='firstname']")
    WebElement firstName;
    @FindBy(css = "input[name='lastname']")
    WebElement lastName;
    @FindBy(css = "input[name='company']")
    WebElement company;
    @FindBy(css = "input[name='street[0]']")
    WebElement streetName;
    @FindBy(css = "input[name='city']")
    WebElement city;
    @FindBy(css = "select[name='region_id']")
    WebElement region;
    @FindBy (css = "input[name='postcode']")
    WebElement postCode;
    @FindBy (css = "select[name=''country_id']")
    WebElement countryDropdown;
    @FindBy(css = "input[name='telephone']")
    WebElement telephone;
    @FindBy(xpath = "//td[class='col col-price']")
    List<WebElement> rates;
    @FindBy(xpath = "//button[contains(.,'Next')]")
    WebElement nextBtn;
    @FindBy(xpath = "//button[contains(.,'Place Order')]")
    WebElement placeOrder;
    public void fillOutInfo(String email,String fisrtName,
                            String lastName,String streetName,
                            String city,String zipcode,
                            String telephone
    )throws InterruptedException{
        this.email.sendKeys(email);
        this.firstName.sendKeys(fisrtName);
        this.lastName.sendKeys(lastName);
        this.streetName.sendKeys(streetName);
        this.city.sendKeys(city);
        BrowserUtils.selectBy(this.countryDropdown,"California","visibleText");
        this.postCode.sendKeys(zipcode);
        System.out.println(BrowserUtils.getFirstOptionSelect(countryDropdown).getText());
        this.telephone.sendKeys(telephone);
        rates.get(0).click();
        nextBtn.click();
        placeOrder.click();
    }


}
