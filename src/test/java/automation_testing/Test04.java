package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test04 extends TestBase {

    @Test
    public void test01(){

        homePageWithThreeArrivalsOnly();
        arrivals1();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());


    }

    @Test
    public void test02(){

        homePageWithThreeArrivalsOnly();
        arrivals2();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());

    }

    @Test
    public void test03(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());

    }



}
