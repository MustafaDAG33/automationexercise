package automation_exercise01;

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

public class E06 {
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
    public void ContactUsForm() throws InterruptedException {

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath(" //*[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement gt = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        System.out.println(gt.getText());
        Assert.assertTrue(gt.isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Messi", Keys.TAB,"messi@gmail.com",
                Keys.TAB, "Tebrik",Keys.TAB, "Hello Messi");

        //7. Upload file
        driver.findElement(By.xpath("//*[@name='upload_file']")).sendKeys("C:\\Users\\LENOVA\\OneDrive\\Masaüstü\\deneme.txt");
        Thread.sleep(3000);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement messageelement =   driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(messageelement.isDisplayed());


        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());
        driver.close();

    }




}
