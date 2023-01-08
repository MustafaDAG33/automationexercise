package automation_testing02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test12 extends TestBase {

    @Test
    public void addBook() {
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

        //13) Kitap eklemek veya çıkarmak için Çıkış sayfasında miktar altındaki metin kutusu değerine tıklayın.
        WebElement quantity = driver.findElement(By.xpath("//*[@title='Qty']"));
        quantity.click();
        quantity.sendKeys(Keys.BACK_SPACE,"2");
        waitFor(3);

        //14) Şimdi yukarıdaki değişiklikten sonra 'Sepeti Güncelle' butonu Tıklanabilir moda dönüşecektir.
        //15) Şimdi bu değişiklikleri yansıtmak için Sepeti Güncelle'ye tıklayın

        WebElement updateBasket = driver.findElement(By.xpath("//*[@name='update_cart']"));

        if(updateBasket.isEnabled()){
            updateBasket.click();

        }


        //16) Kullanıcı, ödeme sırasında Sepeti Güncelleyebilir.
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Basket updated.']")).isDisplayed());
    }
}
