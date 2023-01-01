package automation_exercise01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class E15 extends TestBase {

    @Test
    public void PlaceOrderRegisterbeforeCheckout(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        navigateUrlAndVerifyHomePage();

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//*[@*='signup-name']")).sendKeys("Ronaldo", Keys.TAB,"Ronaldo@gmail.com",Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("7777");

        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select optionDay = new Select(day);
        optionDay.selectByVisibleText("7");

        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select optionMonth = new Select(month);
        optionMonth.selectByVisibleText("May");

        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select optionYear = new Select(year);
        optionYear.selectByVisibleText("2006");
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("ronaldo",Keys.TAB,"cristiano",Keys.TAB,
                "Tech",Keys.TAB,"Portekiz",Keys.TAB,"Istanbul",Keys.TAB,Keys.TAB,"State",Keys.TAB,"City",Keys.TAB,"Zipcode",Keys.TAB,"Number");
        driver.findElement(By.xpath("//*[@*='create-account']")).click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//*[@*='continue-button']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Ronaldo']")).isDisplayed());

        //8. Add products to cart
        driver.findElement(By.xpath("//*[@data-product-id='2']")).click();

        //9. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //10. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //12. Verify Address Details and Review Your Order
        driver.findElement(By.id("address_delivery")).click();

        //13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Thanks");
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("ronaldo",Keys.TAB,"7777",Keys.TAB,"777",
                Keys.TAB,"12",Keys.TAB,"1991",Keys.ENTER);

        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        driver.navigate().refresh();
        driver.findElement(By.xpath("//div[@class='col-sm-8']//li//a[.=' Delete Account']")).click();
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    }



}
