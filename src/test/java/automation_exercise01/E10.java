package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E10 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }



    @Test
    public void homePageIsVisible() {
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());
    }

    @Test
    public void verifyTextSubscription() {
        WebElement webElement = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(webElement.isDisplayed());

    }

    @Test
    public void enterEmail() {
        WebElement webElement =   driver.findElement(By.id("susbscribe_email"));
        webElement.sendKeys("messi@gmail.com", Keys.ENTER);

        WebElement webElement1 = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(webElement1.isDisplayed());
    }


    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }
}
