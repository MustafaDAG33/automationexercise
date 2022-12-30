package selenium_study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T02 {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void dropDown1() throws InterruptedException {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement opt = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select opt1 = new Select(opt);
        opt1.selectByIndex(1);
        Thread.sleep(3000);

    }

    @Test
    public void dropDown2() throws InterruptedException {
        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option);
        select.selectByValue("2");
        Thread.sleep(3000);
    }

    @Test
    public void dropDown3() throws InterruptedException {
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);
    }

    @Test
    public void printDropDown() {
        // 4.Tüm dropdown değerleri(value) yazdırın
        WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option);
        List<WebElement> dropList =    select.getOptions();
        for(WebElement w: dropList){
            System.out.println(w.getText());
        }

    }

    @Test
    public void boyutDropDown() {
        //5. Dropdown’un boyutunu bulun, Dropdown’da 3 öğe varsa konsolda True , degilse False yazdırın.
        WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(option);
        List<WebElement> dropList =    select.getOptions();
        if(dropList.size()==3){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }





}
