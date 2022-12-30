package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {


static WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void checkbox() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // checkbox elementlerini locate edin
        WebElement w1= driver.findElement(By.id("vfb-6-0"));
        WebElement w2= driver.findElement(By.id("vfb-6-1"));
        WebElement w3= driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if(!w1.isSelected()){
            w1.click();
        }
        if(!w3.isSelected()){
            w3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(w1.isSelected());
        Assert.assertTrue(w3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(w2.isSelected());
    }
}
