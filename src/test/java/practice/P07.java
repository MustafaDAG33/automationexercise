package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P07 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testDrop() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement webElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select option = new Select(webElement);
        option.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        WebElement baby =    option.getFirstSelectedOption();
        System.out.println(baby.getText());


        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> list = option.getOptions();
        System.out.println(list.size());
        Assert.assertEquals(28,list.size());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
