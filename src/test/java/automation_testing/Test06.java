package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test06 extends TestBase {

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



    @Test
    public void addToBasket(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

        driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
        driver.findElement(By.xpath("//span[@class='cartcontents']")).click();
        Assert.assertTrue(driver.getTitle().contains("Basket"));
        Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='cart_item']")).isDisplayed());


    }




}
