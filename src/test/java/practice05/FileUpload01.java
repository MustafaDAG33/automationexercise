package practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class FileUpload01 extends TestBase {


    @Test
    public void test01() {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        String path = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Blue and White Abstract Technology LinkedIn Banner.png";

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        driver.findElement(By.id("uploadfile_0")).sendKeys(path);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.id("terms")).click();

        // Submit File buttonuna basınız
        driver.findElement(By.id("submitbutton")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        WebElement text = driver.findElement(By.xpath("//h3[@id='res']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(17));
        wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertTrue(text.isDisplayed());


    }



}
