package selenium.testNG_annotations;

import org.testng.annotations.*;

public class TestNGAnnotations {
    /*
    TestNG stands for Test Next Generation
     */
    // All testNG annotations are below

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite Annotation");
        // use it depending on our needs for testing
        // but usually we set our chromedriver properties
        // deleting cookies
        // it runs before all tests specified in the folder
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest Annotation");
        // when we do DB (dataBase) connection
        // will run only one time
    }


    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass Annotation");
        // also used for common set up before our testing
        // this will engage before test method in the current class
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod Annotation");
        // we can initialize our driver, navigate to webApp, login etc.
    }

    @Test
    public void test() {
        System.out.println("Test 1 Annotation");
        // here we perform our test
    }
    @Test
    public void test2() {
        System.out.println("Test 2 Annotation");
        // here we perform our test
    }
    @Test
    public void test3() {
        System.out.println("Test 3 Annotation");
        // here we perform our test
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod Annotation");
        // we are closing our webpage, tearDown, we can use screenshots
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass Annotation");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest Annotation");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite Annotation");
    }
}
