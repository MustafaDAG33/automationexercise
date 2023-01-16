package practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload01 extends TestBase {

    @Test
    public void test01() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[.='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        String dosyaYolu = "C:\\Users\\LENOVA\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //2.yol
//        String userHome = System.getProperty("user.home");      //-->  "C:\Users\LENOVA"
//        String dosyaYolu1 = userHome+"Downloads\\some-file.txt";
//        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu1)));


    }


}
