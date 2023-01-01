package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class T06_IFrame_WindowHandle extends TestBase {

    @Test
    public void IFrameTest() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site
        // ikinci emojiye tıklayın
        driver.switchTo().frame(driver.findElement(By.id("emoojis")));
        WebElement secondEmoji =   driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));
        secondEmoji.click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        if (secondEmoji.isEnabled()){
            List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//img[@class='emoji']"));
            for (WebElement w : emojiList){
                w.click();
            }
        }

        //ana iframe'e geri dön
        driver.switchTo().parentFrame();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.tagName("input"));
        List<String> form = new ArrayList<>(Arrays.asList("Ocak","Subat","Mart","Nisan","Mayis","Haziran","Temmuz","Agustos","Eylul","Ekim","Kasim"));

        for(int i=0; i< list.size(); i++){
            list.get(i).sendKeys(form.get(i));
        }
        Thread.sleep(3000);

        //uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();


    }

    @Test
    public void windowHandleTest(){

        //       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //       ilk pencereyi al
        String window1 =  driver.getWindowHandle();

        //       "Click Here" butonuna tıklayın
        driver.findElement(By.partialLinkText("Click Here")).click();

        //       setteki tüm pencereyi al
        Set<String> allWindow =  driver.getWindowHandles();


        //       diğer pencereye geç
        for(String eachWindow: allWindow){
            if(!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);
                break;
            }
        }


        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //       Gönder düğmesine tıklayarak
        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.ENTER);


        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        Assert.assertEquals("This access is valid only for 20 days.",driver.findElement(By.tagName("h3")).getText());

        //       Tekrar ilk pencereye geç
        driver.switchTo().window(window1);
        //       İlk pencerede olduğunu doğrula
        Assert.assertEquals("Guru99 Bank Home Page",driver.getTitle());

    }





}
