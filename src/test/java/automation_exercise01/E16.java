package automation_exercise01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class E16 extends TestBase {


    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        navigateUrlAndVerifyHomePage();


        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Ronaldo@gmail.com", Keys.TAB,"7777",Keys.ENTER);


        //6. Verify 'Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Ronaldo']")).isDisplayed());

        //7. Add products to cart
        driver.findElement(By.xpath("//*[@data-product-id='2']")).click();

        //8. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //11. Verify Address Details and Review Your Order
        driver.findElement(By.id("address_delivery")).click();


        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Thanks");
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("ronaldo",Keys.TAB,"7777",Keys.TAB,"777",
                Keys.TAB,"12",Keys.TAB,"1991",Keys.ENTER);

        //14. Click 'Pay and Confirm Order' button
        //15. Verify success message 'Your order has been placed successfully!'
        //16. Click 'Delete Account' button
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
