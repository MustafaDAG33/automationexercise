package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P07 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");

        String window1 = driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.xpath("//div[@class='render']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //    - iphone aratınız
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        WebElement iphoneSonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[.='1-16 of 144 results for']"));
        String iphone[] =   iphoneSonuc.getText().split(" ");
        System.out.println(iphone[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(window1);
        System.out.println(driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım


    }


}
