package automation_exercise03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class E25 extends TestBase {

    @Test
    public void test01() {
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        navigateUrlAndVerifyHomePage();

        //4. Sayfayı aşağıya doğru kaydırın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //5. 'ABONELİK'in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed());

        //6. Yukarı doğru hareket etmek için sağ alt taraftaki oka tıklayın
        driver.findElement(By.id("scrollUp")).click();

        //7. Sayfanın yukarı kaydırıldığını ve 'Otomasyon Mühendisleri için
        // Tam Teşekküllü uygulama web sitesi' metninin ekranda göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
    }

    @Test
    public void test26() throws AWTException {

        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        navigateUrlAndVerifyHomePage();

        //4. Sayfayı aşağıya doğru kaydırın
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);

        //5. 'ABONELİK'in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Subscription']")).isDisplayed());

        //6. Yukarı doğru hareket etmek için sağ alt taraftaki oka tıklayın
        robot.keyPress(KeyEvent.VK_HOME);

        //7. Sayfanın yukarı kaydırıldığını ve 'Otomasyon Mühendisleri için
        // Tam Teşekküllü uygulama web sitesi' metninin ekranda göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Full-Fledged practice website for Automation Engineers']")).isDisplayed());

    }
}
