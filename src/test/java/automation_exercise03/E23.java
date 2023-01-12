package automation_exercise03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class E23 extends TestBase {

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        navigateUrlAndVerifyHomePage();

        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//*[@*='signup-name']")).sendKeys("Fatma", Keys.TAB,"fatmabetul@gmail.com",Keys.ENTER);
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
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Fatma",Keys.TAB,"Betul",Keys.TAB,
                "Tech",Keys.TAB,"Portekiz",Keys.TAB,"Istanbul",Keys.TAB,Keys.TAB,"State",Keys.TAB,"City",Keys.TAB,"Zipcode",Keys.TAB,"Number");
        driver.findElement(By.xpath("//*[@*='create-account']")).click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//*[@*='continue-button']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Fatma']")).isDisplayed());

        //8. Add products to cart
        driver.findElement(By.xpath("//*[@data-product-id='2']")).click();

        //9. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //10. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();


        //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        //14. 'Hesabı Sil' düğmesini tıklayın
        //15. 'HESAP SİLİNDİ!' ve 'Devam Et' düğmesini tıklayın
    }
}
