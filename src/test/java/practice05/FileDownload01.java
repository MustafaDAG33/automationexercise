package practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDownload01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
//        //https://www.selenium.dev/downloads/ adresine gidelim
//        driver.get("https://www.selenium.dev/downloads/");
//
//        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN)
//                .build().perform();
//
//        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
//        driver.findElement(By.xpath("//button[@aria-controls='supported-browsers'] ")).click();
//        waitFor(1);
//        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
//        waitFor(2);
//
//        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
//        driver.findElement(By.xpath("(//a[@class='XqQF9c'])[2]")).click();
//
//        //Açılan pencerede chromedriver'i indirelim
//        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(allWindow.get(1));
//        driver.findElement(By.xpath("//a[.='chromedriver_win32.zip']")).click();
//        waitFor(10);
//
//        //Driver'in indiğini doğrulayalım
//        String path = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip";
//        Assert.assertTrue(Files.exists(Paths.get(path)));

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//*[@type='button'])[83]"));
        actions.moveToElement(browser).perform();
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        Thread.sleep(1000);
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        Thread.sleep(10000);
        //Driver'in indiğini doğrulayalım
        //"C:\Users\Lenovo\Downloads\chromedriver_win32.zip"
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip";
        assert Files.exists(Paths.get(dosyaYolu));

    }



}
