package selenium.testNG_annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethods {
    @BeforeMethod
    public void intialize(){
        System.out.println("From before method");


    }
    @Test
    public void myTest(){
        System.out.println("From test annotation");
    }
    @Test
    public void myTest2(){
        System.out.println("From test 2 annotation");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("From after method");
    }



}
