package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P07_WindowHandle extends TestBase {

    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");

        // 2- nutella icin arama yapın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class='rush-component'])[3]")).click();




        // 4- yeni tab'da acilan urunun basligini yazdirin
        System.out.println("Title = " + driver.getTitle());

        // 5- ilk sayfaya gecip url'i yazdırın
        List<String> l = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(l.get(0));
        System.out.println("Url = " + driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        List<String> l1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(l1.get(1));
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }

    @Test
    public void test02() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("oppo",Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("//div[@id='p-493285594']//div[@class='pro']//a[@class='plink']")).click();
        waitFor(3);

        // Basligin 'Oppo' icerdigini test edin.
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        Assert.assertTrue(driver.getTitle().contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(allWindow.get(0));
        System.out.println("Title = " + driver.getTitle());

    }



}
