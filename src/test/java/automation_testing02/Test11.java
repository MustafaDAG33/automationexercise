package automation_testing02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test11 extends TestBase {

    @Test
    public void removeBook() {

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

        //13) Şimdi, bu kitabı ızgaradan kaldıran Çıkış sayfasındaki Bu simgeyi kaldır'a tıklayın.
        driver.findElement(By.xpath("//*[@title='Remove this item']")).click();

        //14) Kullanıcı, check-out sırasında kitabı kaldırma olanağına da sahiptir.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Mastering JavaScript removed. ']")).isDisplayed());




    }


}
