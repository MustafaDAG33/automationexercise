package automation_testing01;

import org.junit.Test;
import utilities.TestBase;

public class Test02 extends TestBase {

    @Test
    public void test02(){

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        //3) Click on Shop Menu
        //4) Now click on Home menu button
        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contains only three Arrivals

        homePageWithThreeArrivalsOnly();



    }

}
