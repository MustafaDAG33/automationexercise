package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class T05_IFrame_WindowHandle extends TestBase {

    @Test
    public void iFrameOdev(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //saydafadi toplam iframe sayisi
        List<WebElement> iframe =   driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());

        //sayfa basliginda editor yazisinin oldugunu test edin.
        WebElement w = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(w.getText().contains("Editor"));

        //paragraftaki yaziyi silelim.
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[.='Your content goes here.']")).clear();

        //iframe'in icindeyim yazin.
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("IFrame'in icindeyim");
        driver.switchTo().parentFrame();

        //alt kisimdaki yazinin 'Elemental Selenium' yazisini icerdigini test edelim.
        WebElement w1 =   driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(w1.getText().contains("Elemental Selenium"));


    }

    @Test
    public void test02() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        //Title'in "Windows" oldugunu test edin
        //Click here a tiklayin
        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin

        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1 = driver.getWindowHandle();
        System.out.println(window1);


        Assert.assertEquals("Windows",driver.getTitle());
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        Thread.sleep(3000);

        Set<String> allwindow =   driver.getWindowHandles();

        for(String eachWindow: allwindow){

            if(!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);
                break;
            }
        }
        Assert.assertEquals("New Window",driver.getTitle());


    }



}
