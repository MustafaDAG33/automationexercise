package automation_exercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class E09 {

    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");

    }

    @Test
    public void searchProductTest(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
        Assert.assertTrue(homePage.isDisplayed());


        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedTitle = "ALL PRODUCTS";
        String actualTitle  = driver.getTitle().toUpperCase();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //6. Enter product name in search input and click search button
        WebElement webElement =   driver.findElement(By.xpath("//input[@id='search_product']"));
        webElement.sendKeys("Tshirt");

        driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());

        //8. Verify all the products related to search are visible
        List<WebElement> productList = driver.findElements(By.xpath("//*[text()='View Product']"));

        for(WebElement w: productList){
            Assert.assertTrue(w.isDisplayed());

        }

        driver.close();



    }
}
