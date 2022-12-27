package automation_exercise;

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

public class E05 {

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
    public void RegisterUserwithexistingemail(){
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@*='signup-name']")).sendKeys("Messi", Keys.TAB,"messi@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@*='signup-button']")).click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
