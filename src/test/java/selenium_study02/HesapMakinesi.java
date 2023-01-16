package selenium_study02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Random;

public class HesapMakinesi extends TestBase {

    @Test
    public void test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        List<WebElement> sayilar = driver.findElements(By.xpath("//span[@class='btn btn-outline-primary']"));
        List<WebElement> islemler = driver.findElements(By.xpath("//span[@class='operator btn btn-outline-success']"));
        WebElement esittir = driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']"));



        int r1 = (int)(Math.random()*10);
        int r2 = (int)(Math.random()*10);
        int rIslem = (int)(Math.random()*4);

        sayilar.get(r1).click();
        islemler.get(rIslem).click();
        sayilar.get(r2).click();
        esittir.click();
        waitFor(6);
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='screen']"));


        double sayi1 = Double.parseDouble(sayilar.get(r1).getText());
        double sayi2 = Double.parseDouble(sayilar.get(r2).getText());
        //Sonucu konsola yazdırıp
        //Sonucun doğrulamasını yapalım

        switch (rIslem){
            case 0 :
                Assert.assertTrue((sayi1+sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;
            case 1:
                Assert.assertTrue((sayi1-sayi2)==Double.parseDouble(sonucYazisi.getText()) );
                break;
            case 2:
                Assert.assertTrue((sayi1/sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;
            case 3:
                Assert.assertTrue((sayi1*sayi2)==Double.parseDouble(sonucYazisi.getText()));
                break;


        }








    }









}
