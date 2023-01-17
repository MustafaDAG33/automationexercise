package practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitlyWait01 extends TestBase {
     /*
                                    - Explicit Wait -
        Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
    “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
    Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
    Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
        Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
    sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
Syntax:
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));
     */


    @Test
    public void test01() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım

        //visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));//hello eorld yazisi gorunene kadar beklettik
        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed());

    }

    @Test
    public void invisibilityTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World! yazısının çıktığını doğrulayalım
        //invisibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//img[@src='../dynamic-loading/img/ajax-loader.gif']"))));
        //loading... kaybolana kadar bekliyoruz

        Assert.assertTrue(driver.findElement(By.id("finish")).isDisplayed());

    }


}
