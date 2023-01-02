package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test05 extends TestBase {

    @Test
    public void test01(){

        homePageWithThreeArrivalsOnly();
        arrivals1();

        WebElement reviewsButton = driver.findElement(By.xpath("//li[@class='reviews_tab']"));
        reviewsButton.click();

        WebElement reviews = driver.findElement(By.xpath("//*[@id='comments']"));
        Assert.assertTrue(reviews.isDisplayed());



    }

    @Test
    public void test02(){

        homePageWithThreeArrivalsOnly();
        arrivals2();

        WebElement reviewsButton = driver.findElement(By.xpath("//li[@class='reviews_tab']"));
        reviewsButton.click();

        WebElement reviews = driver.findElement(By.xpath("//*[@id='comments']"));
        Assert.assertTrue(reviews.isDisplayed());


    }

    @Test
    public void test03(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

        WebElement reviewsButton = driver.findElement(By.xpath("//li[@class='reviews_tab']"));
        reviewsButton.click();

        WebElement reviews = driver.findElement(By.xpath("//*[@id='comments']"));
        Assert.assertTrue(reviews.isDisplayed());


    }


}
