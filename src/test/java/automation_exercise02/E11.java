package automation_exercise02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E11 {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click 'Cart' button
    //5. Scroll down to footer
    //6. Verify text 'SUBSCRIPTION'
    //7. Enter email address in input and click arrow button
    //8. Verify success message 'You have been successfully subscribed!' is visible

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void homePageIsVisible() {
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());
    }

    @Test
    public void clickCart() {
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

    }

    @Test
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Test
    public void substriction() {
        WebElement webElement = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(webElement.isDisplayed());

        WebElement we =   driver.findElement(By.id("susbscribe_email"));
        we.sendKeys("messi@gmail.com", Keys.ENTER);

        WebElement webElement1 = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(webElement1.isDisplayed());
    }

}
