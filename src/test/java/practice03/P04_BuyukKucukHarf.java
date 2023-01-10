package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P04_BuyukKucukHarf extends TestBase {


    @Test
    public void test01() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");

        //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h","e","l","l",Keys.SHIFT,"o");
        waitFor(3);

    }

    @Test
    public void test02() {

        //        -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        String window1 = driver.getWindowHandle();

        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        waitFor(3);
        driver.findElement(By.xpath("//*[.='Fleet']")).click();
        waitFor(3);

        //        -Sayfa başlığının Fleet içerdiğini test edelim
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));

        Assert.assertTrue(driver.getTitle().contains("Fleet"));




    }




}
