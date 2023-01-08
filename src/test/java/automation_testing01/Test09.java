package automation_testing01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test09 extends TestBase {

    @Test
    public void test01() {

        //1) Tarayıcıyı açın
        //2) "http://practice.automationtesting.in/" URL'sini girin
        //3) Mağaza Menüsüne tıklayın
        //4) Şimdi Ana menü düğmesine tıklayın
        //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
        //6) Ana sayfa yalnızca üç Gelenler içermelidir
        homePageWithThreeArrivalsOnly();


        //7) Şimdi Gelenler'deki resme tıklayın
        //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir
        arrivals3();

        //10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
        driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();

        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir .
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='wpmenucart-contents']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' “Mastering JavaScript” has been added to your basket.']")).isDisplayed());

        //12) Şimdi, ödeme sayfasına ilerlemek için gezinen Öğe bağlantısına tıklayın.
        driver.findElement(By.xpath("//*[@class='wpmenucart-contents']")).click();

        //13) Kullanıcı, kitabı sepete ekledikten sonra menü öğesindeki Öğe bağlantısını tıklayabilir ve bu da ödeme sayfasına yönlendirir.
        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']"));
        Assert.assertTrue(proceedToCheckout.isDisplayed());

        //14) Toplamda 50rps indirim almak için Kupon kodunu 'krishnasakinala' olarak girin.
        driver.findElement(By.xpath("//*[@class='input-text']")).sendKeys("krishnasakinala", Keys.ENTER);

        //15) 15) Kullanıcı, kupon metin kutusuna 'krishnasakinala' girerek toplam fiyat üzerinden 50 rps indirim sağlayan
        //kupon uygulayamaz çünkü kupon kitap fiyatı > 450 rps için geçerlidir.
        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='The minimum spend for this coupon is ']")).isDisplayed());
    }


}
