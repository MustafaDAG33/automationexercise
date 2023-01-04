package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P08 extends TestBase {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        String window1 = driver.getWindowHandle();

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");
        driver.switchTo().defaultContent();

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        WebElement elesele = driver.findElement(By.xpath("//a[.='Elemental Selenium']"));
        Assert.assertTrue(elesele.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elesele.click();


        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandle = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));

        System.out.println(driver.getTitle());


        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourcelabs = driver.findElement(By.cssSelector("a[rel='noopener noreferrer']"));
        Assert.assertTrue(sourcelabs.isDisplayed());

        // Source labs linkine tıklayın
        sourcelabs.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(2));

        System.out.println(driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(window1);
        System.out.println(driver.getCurrentUrl());

        // ilk sekmeyi kapatalım
        driver.close();
    }
}
