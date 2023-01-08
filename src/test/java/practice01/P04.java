package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P04 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for(int i=0; i<100; i++){
            addButton.click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement> list = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        List<String> yuz = new ArrayList<>();
        for(WebElement w: list){
            yuz.add(w.getText());
        }
        Assert.assertEquals(100, yuz.size());

        // 90 defa delete butonuna basınız
        for(int i=0; i<90; i++){
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> list1 = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        List<String> on = new ArrayList<>();
        for(WebElement w: list1){
            on.add(w.getText());
        }
        Assert.assertEquals(10, on.size());

        // Sayfayı kapatınız
        driver.quit();



    }
}
