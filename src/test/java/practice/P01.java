package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {



    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //-"sahibinden.com" adresine gidelim
        driver.get("https://www.sahibinden.com");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle =    driver.getTitle();
        System.out.println(actualTitle);

        System.out.println();

        String actualUrl =   driver.getCurrentUrl();
        System.out.println(actualUrl);

        //-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        String expected= "Oto";
        Assert.assertFalse(actualUrl.contains(expected) && actualTitle.contains(expected));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle =  driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();

        driver.quit();
    }




}
