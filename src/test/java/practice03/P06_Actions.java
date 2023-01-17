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
        WebElement alan = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions actions  = new Actions(driver);
        actions.moveToElement(alan).clickAndHold();

        for(int i=0; i<10; i++){

            actions.moveByOffset(5,5);
        }

        for(int i=0; i<10; i++){

            actions.moveByOffset(-10,-10);
        }

        for(int i=0; i<10; i++){

            actions.moveByOffset(5,5);
        }

        actions.release().build().perform();
        waitFor(5);

        //    - Clear butonuna basin
        driver.findElement(By.xpath("//*[text()='Clear']")).click();



    }




}
