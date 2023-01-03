package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test04 extends TestBase {

    //1) Tarayıcıyı açın
    //2) "http://practice.automationtesting.in/" URL'sini girin
    //3) Mağaza Menüsüne tıklayın
    //4) Şimdi Ana menü düğmesine tıklayın
    //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
    //6) Ana sayfa yalnızca üç Gelenler içermelidir
    //7) Şimdi Gelenler'deki resme tıklayın
    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir. 10) Tıkladığınız kitap için
    //Açıklama sekmesine tıklayın.
    //11) Kullanıcının tıkladığı kitapla ilgili bir açıklama olmalıdır.

    @Test
    public void test01(){

        homePageWithThreeArrivalsOnly();
        arrivals1();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());


    }

    @Test
    public void test02(){

        homePageWithThreeArrivalsOnly();
        arrivals2();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());

    }

    @Test
    public void test03(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

        WebElement descriptionButton = driver.findElement(By.xpath("//li//a[.='Description']"));
        descriptionButton.click();
        WebElement productDescription = driver.findElement(By.xpath("//h2[.='Product Description']"));
        Assert.assertTrue(productDescription.isDisplayed());

    }



}
