package selenium.selenium_recap;

public class SeleniumRecap {
    /*
    1. What is selenium?
      Is a testing tool,it is used to automate web applications for testing purpose.
      It's a open source tool.
      Why it is widely used by companies is because it is free to use.Also it is one the leading testing tool.
    Advantages
    -- Free to use
    -- It supports multiple browsers (Chrome,MS Edge,Safari,Firefox)
    -- It is supported by many programming languages (Java,Python,C++,C# )
    -- Big community (support comes from here)
    Disadvantages
    -- We cannot automate CAPTCHA,Pictures,Videos,Built in applications
    -- There is no customer support line
    -- It is limited to test only web applications
    -- It does not have built in report system (We have to use TestNG Report,Cucumber Report,Spark Report etc.)
    2. What type of testing can you perform in Selenium?
    -- Smoke test   -- Regression   -- Functional(positive/negative)
    3. What kind of testing you are not able to perform with Selenium?
    -- Performance testing
    -- Manual testing
    -- Non-Functional testing(load,stress testing)
    4. What are the locator types? What is a locator?
    -- Locator is way to locate web elements in the DOM(Document Object Model).Locator are basically address of web element on the website
    Locators are:
    -ID
    -LinkText
    -ClassName
    -TagName
    -Name
    -PartialLinkText
    -CSS
    -XPATH
    5. How do handle dynamic elements?
      We can use multiple ways of locating web elements.But as of now,we already have unique elements found and they're pretty much stable.
      However, back in the days when we were starting, we used to face challenges while locating web elements.There i can sau that we used
      parent/child relationship,following-sibling,preceding-sibling, and contains text.
    6. What is the difference between driver.get(); and driver.navigate();?
      Navigate -- It does not wait for web elements to ber loaded on web page.
      navigate has some methods such as:
      refresh,back,forward
      driver.get(); -- is waits certain amount of time for the web page to be loaded
                  -- this does not have methods as navigateTo does
    7. What is the difference between driver.close and driver.quit?
      The main difference is driver.close closes only the current window where driver is located/looking at
      Other remaining windows will stay open.
      But in driver.quit, it shuts down all opened windows(windows that were opened with selenium)
    8. What is XPATH?
      Basically it is a way of locating web elements in the web page.It is a set of chars that is passed as an address/location of a web element in the web.
    8.1 What types of XPATH do you know?
      Absolute XPATH - it starts from beginning of a html to the desired location
      Relative XPATH - it directly goes to the desired location(child)
    8.2 Which one of you used most often?
      Obviously, I use relative XPATH since it is reliable and focuses on parent/child location whereas Absolute XPATH
      is not quite reliable since web page might get updated and would break my xpath.
    9. How do handle dropdowns?How do you handle static dropdown?
      -- First, when i inspect the DOM I normally check if this dropdown tag name is 'select',if it is
      then i have implemented re-usable methods that handle dropdown.It is implemented with Select class.
      If the tagName is not select, then I will try to sendKeys or use Action class methods to hover and click.
    9.1 Select Methods
      Select select = new Select(element);
      selecting options from the dropdown:
      visibleText
      value
      index

      Other methods within the same class
      getOptions
      getFirstSelectedOption
      etc.
    10. What kind of Exceptions have you faced while doing automation?
      NuSuchElementException
      StaleElementReferenceException
      NullPointerException
      ElementNotIntractableException
      TimeOutException
      NoSuchFrameException
      NoSuchWindowException
      UnHandledAlertException
    11. How do you handle alerts?(Popups/JS Alerts)
      We have couple type of alerts.
      One is JS Alert.
        For this type we can use some methods from Alert interface
        Alert alert = driver.switchTo.alert();
        alert.accept();
        alert.dismiss();
        alert.getText();
        alert.senKeys("text goes here");
        I already have reusable methods that I implemented very recently.

      Second one is html Alert.
        I treat is as normal html where I inspect and find the location of closing button

      Os Alerts
        This is usually pops up from your computer
        It is an alert that is built in to your machine
          We can use Robot Class
     12. How do you handle IFrames?
       We can switch our driver to that specific iFrame either with id or name or find xpath for the iFrame.
       NOTE: if you directly go inside the iFrame and ignored switching your driver and locate one specific element, and when you run your automation,it will
       throw NoSuchElementException.
       NOTE: if you made a mistake and provided wrong iFrame id name or xpath, you will get NoSuchFrameException.
     12.1 How to switch the driver?
       driver().switchTo.frame("id or name or xpath")
       if we pass id on name of the iframe, it runs little slower.
       if we pass xpath of the iFrame it runs little faster comparing to id/name.
     12.2 How do handle nested iFrames?
       We need to switch our driver as long as needed to the desired iframe.
       driver().switchTo.frame("id/name/xpath")
       driver().switchTo.frame("id/name/xpath")

       To bring back the driver to original state.
       driver().switchTo.defaultContent();
       driver().parent
     13. Keyboard and mouse actions
       We can use Actions class. this class helps us to manipulate with mouse and keyboard on the webPage.
       Action action = new Action(driver);
       action.
        - MoveByOffset(x,y) - moves based on the x, y off of element
        - DoubleClick()     - double clicks
        - SenKeys           - inputs some text into input field
        - ContextClick      - right-click on the web element
        - ClickAndHold      - clicks and hol an element
        - release           - it will release whatever it has been holding
        - DragAndDrop       - drags an element drops
        - MoveToElement     - it hovers over the element
        - ScrollByAmount    - scrolls the page based on the numbers (int) provided in the method
        - PERFORM           - this will be followed at the end of methods. MUST HAVE IT.

        KeyBoard action.
          sendKeys("text"keys.ENTER)
     14. What is the difference between findElement and findElements?
       findElement  - returns single web element   -- if it fails, it throws NoSuchElementException
       findElements - returns list of web elements -- if it fails, it returns empty list
     15. Can you tell me some methods from driver and webElement?

       driver methods:
         driver.get();                                                 -- opens up the page
         driver.navigateTo()                                           -- opens up the page
         driver.manage.timeouts.implicitWait(DurationOfSeconds(10))    -- waits for 10 seconds
         driver.manage.window.maximize/minimize                        -- maximize/minimize windows
         driver.getTitle();                                            -- returns String for title
         driver.getCurrentUrl();                                       -- returns string for URL
         driver.getPageSource                                          -- returns html structure
         driver.switch().ToWindow/frame/alert                          -- switch driver to desired location
         driver.findElement/s                                          -- finds element on the web page
         quit                                                          -- shuts down all opened windows
         close                                                         -- closes only current window
         getWindowHandles                                              -- returns unique set of id-s
       WebElement methods:
         getText       -- gets a text from the web page
         sendKeys      -- inputs text into the input field
         click         -- clicks on webElement
         clear         -- clears the text from input
         isDisplayed   -- boolean, checks if webElement is displayed
         isEnabled     -- boolean, check if element is enabled
         getAttribute  -- returns attribute's value as a string
         getCSSValue   -- returns some value from CSS

      16.How do you handle multiple windows?
        Get unique id of the windows with the help of getWindowHandle/s
        Set<String> ids = driver.getWindowHandles - all unique ids
        String id- driver.getWindowHandle
        I have re-usable methods to switch my driver if i need to
        We can also switch by window title if there are more than 2 windows
      17. How do scroll the pages?
        I can use Actions class
        I can use Point class
        I can use JavaScript methods
      18. HOw do you upload a file?
        I just simply sendKeys into the upload button by providing file location
      19. Difference between SoftAssert an hard Assert
        SoftAssert skips failure while our automation is running whereas hard Assert it stops the execution
        However SoftAssert has a method called assertAll, if this method is skipped, then we wont be able
        to see where assertion is failed.If we use this method, then we need to use it at the very end of our code.
        And then it will indicate where our assertion had failed when our automation ran.

        In order to use SoftAssert, we just simply create an object from SoftAssert class.
        SoftAssert softAssert = new SoftAssert();

        In order to use hard Assert, we simply use it's static method
        Assert.assertEquals()
      20. Singleton design
        It is way of centralizing our driver by encapsulating it.this means I use one driver across the frameWork.
        Driver is initiated only from one place.
      21. Tel me some TestNG annotation?
        @BeforeMethod
        @Test
        @BeforeClass
        @BeforeSuite
        @AfterMethod
        @AfterClass
        @AfterSuite
        @Parameters   - widely used in xml files for parametrizing test data, ar setting up test
        @DataProvider - widely used for testing the same test with different sets of data
      22. Wait times -- Synchronization Issues
        ImplicitWaits
          This is general wait for web page to loaded
          We can specify the wait time as seconds
        ExplicitWaits
          This is specific wait for specific element with specific conditions
          This needs driver and web element.
          WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(10));
          element = wait.until(ExpectedConditions.visibilityOf(element))
          element.click();
          if it fails based on location issue we will get TimeOutException
        FluentWaits
          This will work exactly the same as explicit wait except it adds frequency(periodically) on how often
          one specific element is available/visible.






























     */


}
