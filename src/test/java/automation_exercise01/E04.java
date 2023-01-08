package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E04 {
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
    public void LogoutUser(){

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@*='login-email']")).sendKeys("messi@gmail.com", Keys.TAB,"1111");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@*='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        String actualTitle =   driver.getTitle();
        String expectedTitle = "Signup / Login";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @After
    public void tearDown(){
        driver.close();
    }



}
