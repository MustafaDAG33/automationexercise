package automation_exercise01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class E13 extends TestBase {

    @Test
    public void verifyProductQuantityInCart() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        navigateUrlAndVerifyHomePage();


        //4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[2]")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify product detail is opened
        WebElement detail = driver.findElement(By.xpath("//div[@class='product-details']"));
        Assert.assertTrue(detail.isDisplayed());

        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantity.sendKeys(Keys.DELETE,"4");
        Thread.sleep(3000);


        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        WebElement proQuantity = driver.findElement(By.xpath("//button[@class='disabled']"));
        String expected = "4";
        String actual = proQuantity.getText();
        Assert.assertEquals(expected, actual);

    }




}
