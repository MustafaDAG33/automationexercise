package utilities;

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
import java.util.List;

public abstract class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.quit();

    }


    public void navigateUrlAndVerifyHomePage(){

        driver.get("http://automationexercise.com");
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());
    }


    public void homePageWithThreeArrivalsOnly(){

        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.xpath("//a[.='Shop']")).click();

        driver.navigate().back();
        driver.navigate().forward();

        driver.findElement(By.xpath("//a[.='Home']")).click();

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='woocommerce']//ul[@class='products']"));
        Assert.assertEquals(3,list.size());

    }


    public void arrivals1(){
        WebElement seleniumRuby =  driver.findElement(By.xpath("//*[@title='Selenium Ruby']"));
        Assert.assertTrue(seleniumRuby.isEnabled());
        seleniumRuby.click();
        Assert.assertTrue(driver.getTitle().contains("Selenium Ruby"));

    }


    public void arrivals2(){
        WebElement thinkingInHtml = driver.findElement(By.xpath("//*[@title='Thinking in HTML']"));
        Assert.assertTrue(thinkingInHtml.isEnabled());
        thinkingInHtml.click();
        Assert.assertTrue(driver.getTitle().contains("Thinking in HTML"));

    }


    public void arrivals3(){
        WebElement masteringJavaScript =  driver.findElement(By.xpath("//*[@title='Mastering JavaScript']"));
        Assert.assertTrue(masteringJavaScript.isEnabled());
        masteringJavaScript.click();
        Assert.assertTrue(driver.getTitle().contains("Mastering JavaScript"));

    }





}
