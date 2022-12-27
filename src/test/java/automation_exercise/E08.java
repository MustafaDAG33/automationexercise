package automation_exercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E08 {
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
    public void VerifyAllProductsandproductdetailpage(){

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//html[@lang='en']")).isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String actualTitle = driver.getTitle().toUpperCase();
        String expectedTitle = "ALL PRODUCTS";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='View Product']")).isDisplayed());

        //7. Click on 'View Product' of first product
        List<WebElement> productList = driver.findElements(By.xpath("//*[text()='View Product']"));
        productList.get(0).click();

        //8. User is landed to product detail page
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Product Details";
        Assert.assertTrue(actualTitle1.contains(expectedTitle1));

        //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
        WebElement pInfo=   driver.findElement(By.xpath("//div[@class='product-information']"));
        List<String> pInfoList = new ArrayList<>(Arrays.asList(pInfo.getText().split("\n")));
        Assert.assertEquals(7,pInfoList.size());
        driver.close();
    }



}
