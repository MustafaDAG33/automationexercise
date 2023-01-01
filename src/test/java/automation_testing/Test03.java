package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;



public class Test03 extends TestBase {

    @Test
    public void test01(){

        homePageWithThreeArrivalsOnly();
        arrivals1();

    }

    @Test
    public void test02(){

        homePageWithThreeArrivalsOnly();
        arrivals2();

    }

    @Test
    public void test03(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

    }



}
