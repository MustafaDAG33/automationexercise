package automation_testing03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class MyAccount_Login extends TestBase {

    @Test
    public void validUsernamePassword() {

        //1) Tarayıcıyı açın
        //2) “http://practice.automationtesting.in/” URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//*[.='My Account']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //4) Kullanıcı adı metin kutusuna kayıtlı kullanıcı adını
        //girin 5) Şifre metin kutusuna şifreyi girin
        //6) Giriş düğmesine tıklayın
        driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("Mcrespo@gmail.com", Keys.TAB,
                "MCrespo!!88811!!??");

        WebElement register =   driver.findElement(By.xpath("//input[@name='register']"));
        register.click();
        waitFor(5);


        //7) Kullanıcı web sayfasına başarılı bir şekilde giriş yapmalıdır.
        //driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));




    }
}
