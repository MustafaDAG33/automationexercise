package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E12 {

    static WebDriver driver;

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

    @After
    public void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void addProductsInCart() {

        //3. Verify that home page is visible successfully
        WebElement homePageLogo = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homePageLogo.isDisplayed());


        //4. Click 'Products' button
        //driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.partialLinkText(" Products")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Men Tshirt']")).isDisplayed());


        //10. Verify their prices, quantity and total price

        //prices
        WebElement firstProduct=  driver.findElement(By.xpath("(//p[text()='Rs. 500'])[1]"));
        WebElement secondProduct=  driver.findElement(By.xpath("(//p[text()='Rs. 400'])[1]"));

        Assert.assertEquals("Rs. 500",firstProduct.getText());
        Assert.assertEquals("Rs. 400",secondProduct.getText());

        //quantity
        WebElement fp = driver.findElement(By.xpath("(//button[@class='disabled'])[1]"));
        WebElement sp = driver.findElement(By.xpath("(//button[@class='disabled'])[2]"));

        Assert.assertEquals("1",fp.getText());
        Assert.assertEquals("1",sp.getText());


        //total prices
        WebElement product1=  driver.findElement(By.xpath("(//p[text()='Rs. 500'])[2]"));
        WebElement product2=  driver.findElement(By.xpath("(//p[text()='Rs. 400'])[2]"));

        Assert.assertEquals("Rs. 500",product1.getText());
        Assert.assertEquals("Rs. 400",product2.getText());





    }








}
