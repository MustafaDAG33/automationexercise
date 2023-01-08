package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E03 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void LoginUserwithincorrectemailandpassword(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());

        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mustafa@gmail.com", Keys.TAB,"3317");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed());
        driver.close();
    }


}
