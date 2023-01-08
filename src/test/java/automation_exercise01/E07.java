package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E07 {

    WebDriver driver;

    @Before
    public void setUp(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void VerifyTestCasesPage(){

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to test cases page successfully
        String actualTitle =    driver.getTitle();
        String expectedTitle = "Test Cases";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }




}
