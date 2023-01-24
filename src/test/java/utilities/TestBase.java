package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

    /*
1- <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports --> pom.xml'e yüklemek
2- Eğer extentReport almak istersek ilk yapmamız gereken ExtentReport class'ından bir obje oluşturmak
3- HTLM formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturmak
 */
    static ExtentReports extentReports;//Raporlamayı başlatırız
    static   ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    static   protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz

    protected static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //----------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ExtentReports/htmlreport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Sonucu");
        extentTest=extentReports.createTest("Extent Tests","Test Raporu");
    }

    @After
    public void tearDown(){
        //driver.quit();
        extentReports.flush();

    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
