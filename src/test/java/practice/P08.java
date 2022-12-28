package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P08 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        //- ebay sayfasina gidiniz
        driver.get("https://www.ebay.com");


        //- electronics bolumune tiklayiniz
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();


        //- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
        //- her sayfanin basligini yazdiralim
        List<WebElement> list = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

        for(int i=0; i<list.size(); i++){
            List<WebElement> list1 = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            list1.get(i).click();
            System.out.println(i+". baslik"+   driver.getTitle());
            driver.navigate().back();

        }


        //- sayfayi kapatalim
        driver.close();

    }
}
