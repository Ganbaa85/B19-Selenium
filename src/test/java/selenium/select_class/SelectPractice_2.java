package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selenium.utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class SelectPractice_2 {
    @Test
    public void bookFlight() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("input[value='oneway']")).click();
        WebElement passCount = driver.findElement(By.cssSelector("select[name='passCount']"));
//        Select passengerSelect = new Select(passCount);
//        passengerSelect.selectByValue("4");
        BrowserUtils.selectBy(passCount, "4", "value");
//        Select departCity = new Select(driver.findElement(By.cssSelector("select[name='fromPort']")));
//        departCity.selectByVisibleText("Seattle");
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromPort']")), "Seattle", "visibleText");
//        Select monthSelect = new Select(driver.findElement(By.cssSelector("select[name='fromMonth']")));
//        monthSelect.selectByIndex(12);
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromMonth']")), "11", "index");
//        Select daySelect = new Select(driver.findElement(By.cssSelector("select[name='fromDay']")));
//        daySelect.selectByIndex(20);
        BrowserUtils.selectBy(driver.findElement(By.cssSelector("select[name='fromDay']")), "20", "index");
//        Select destinationSelect = new Select(driver.findElement(By.cssSelector("select[name='toPort']")));
//        destinationSelect.selectByVisibleText("New York");
        BrowserUtils.selectBy((driver.findElement(By.cssSelector("select[name='toPort']"))), "New York", "visibleText");
//        Select arriveMonth = new Select(driver.findElement(By.cssSelector("select[name='toMonth']")));
//        arriveMonth.selectByIndex(12);
        BrowserUtils.selectBy((driver.findElement(By.cssSelector("select[name='toMonth']"))), "11", "index");
//        Select arriveDate = new Select(driver.findElement(By.cssSelector("select[name='toDay']")));
//        arriveDate.selectByIndex(23);
        BrowserUtils.selectBy((driver.findElement(By.cssSelector("select[name='toDay']"))), "12", "index");
        driver.findElement(By.cssSelector("input[value='First']")).click();
        WebElement airlines = driver.findElement(By.cssSelector("select[name='airline']"));
        List<WebElement> allAirlines = BrowserUtils.getOptions(airlines);
        for (WebElement eachAirlines : allAirlines) {
            System.out.println(BrowserUtils.getText(eachAirlines));

        }


        BrowserUtils.selectBy((driver.findElement(By.cssSelector("select[name='airline']"))), "Pangea Airlines", "visibleText");
        driver.findElement(By.cssSelector("input[name='findFlights']")).click();
        WebElement message = driver.findElement(By.xpath("//b[contains(.,'After flight finder - No Seats Avaialble ')]"));
        String actualText = BrowserUtils.getText(message);
        System.out.println(actualText);


    }

    @Test
    public void taskSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectCountrySearchBar = driver.findElement(By.xpath("//span[@id='select2-country-container']//following-sibling::span[@class='select2-selection__arrow']"));
        selectCountrySearchBar.click();
        WebElement sendKeysToSearchBar = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
        sendKeysToSearchBar.sendKeys("India" + Keys.ENTER);
        WebElement multiSelectState = driver.findElement(By.cssSelector("span[class='select2-selection select2-selection--multiple']"));
        multiSelectState.sendKeys("Illinois" + Keys.ENTER);
        WebElement puertoRiceSelect = driver.findElement(By.xpath("//span[contains(text(),'Puerto Rico')]"));
        puertoRiceSelect.click();
        sendKeysToSearchBar = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@class='select2-search__field']"));
        sendKeysToSearchBar.sendKeys("Virgin Islands", Keys.ENTER);
        WebElement selectFile = driver.findElement(By.cssSelector("select[id='files']"));
        BrowserUtils.selectBy(selectFile, "Java", "visibleText");
        Thread.sleep(1000);



    }
}
