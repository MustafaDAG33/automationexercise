package selenium_study01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T01 {

    WebDriver driver;

    @Before
    public void setUp(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        //1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com");


        //2-"BOOKS" başlığının görünür olduğunu doğrulayın
        SearchContext shadow = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")).getShadowRoot();
        WebElement bookShadow =   shadow.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(bookShadow.isDisplayed());

        //3-Arama çubuğunda "Selenium" u aratın.
        SearchContext shadow1 = driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']")).getShadowRoot();
        shadow1.findElement(By.cssSelector("input[id='input']")).sendKeys("Selenium", Keys.ENTER);

        //4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.


    }





}
