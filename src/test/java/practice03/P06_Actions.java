package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P06_Actions extends TestBase {

    @Test
    public void test01() {

        //    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions  = new Actions(driver);
        WebElement alan = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));

        waitFor(3);

        //    - Clear butonuna basin
        //    - Son olarak sayfayı temizleyiniz



    }




}
