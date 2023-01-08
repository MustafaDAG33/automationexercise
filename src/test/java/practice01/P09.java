package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P09 {

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
        //       https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //       cookies uyarisini kabul ederek kapatin
        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String googleTitle =   driver.getTitle();
        Assert.assertTrue(googleTitle.contains("Google"));

        //       Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);


        //       Bulunan sonuc sayisini yazdirin
        WebElement webElement = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(webElement.getText());


        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        List<String> list = new ArrayList<>(Arrays.asList(webElement.getText().split(" ")));
        String result =  list.get(1);
        result= result.replace(".","");
        int r = Integer.parseInt(result);
        Assert.assertTrue(r>10000000);



        //       Sayfayi kapatin
        driver.close();



    }










}
