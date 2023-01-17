package practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUpload01 extends TestBase {

    @Test
    public void test01() {
        String path = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Blue and White Abstract Technology LinkedIn Banner.png";//masaustu dosya pathi
        Assert.assertTrue(Files.exists(Paths.get(path)));//Files.exists dosya var mi

        //upload
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        dosyaSec.sendKeys(path);
        driver.findElement(By.id("file-submit")).click();


    }

    @Test
    public void test02() {
        //download
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(10);

        String path = System.getProperty("user.home")+"Downloads\\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(path)));



    }
}
