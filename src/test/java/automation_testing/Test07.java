package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test07 extends TestBase {

    //1) Tarayıcıyı açın
    //2) "http://practice.automationtesting.in/" URL'sini girin
    //3) Mağaza Menüsüne tıklayın
    //4) Şimdi Ana menü düğmesine tıklayın
    //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
    //6) Ana sayfa yalnızca üç Gelenler içermelidir
    //7) Şimdi Gelenler'deki resme tıklayın
    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir
    //10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
    //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir .
    //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
    //13) Stoktaki kitaplardan daha fazla kitap seçin.Örneğin, stokta 20 kitap varsa 21 eklemeyi deneyin.
    //14) Sepete ekle düğmesini tıklayın
    //15) Şimdi 1 ile 20 arasında bir değer girmeniz gerektiği gibi bir hata mesajı veriyor.

    @Test
    public void addToBasket() throws InterruptedException {

        homePageWithThreeArrivalsOnly();
        arrivals3();

        driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
        driver.findElement(By.xpath("//span[@class='cartcontents']")).click();
        Assert.assertTrue(driver.getTitle().contains("Basket"));
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='cart_item']")).isDisplayed());

        WebElement quantityButton = driver.findElement(By.xpath("//input[@type='number']"));
        quantityButton.click();
        quantityButton.sendKeys(Keys.DELETE,"70000");

        driver.findElement(By.xpath("//input[@name='update_cart']")).click();//update basket
        Thread.sleep(3000);






    }
}
