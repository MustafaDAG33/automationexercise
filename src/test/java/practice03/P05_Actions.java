package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P05_Actions extends TestBase {

    @Test
    public void test01() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        WebElement kutu = driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        kutu.click();

        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula

        Assert.assertTrue(driver.findElement(By.xpath("//*[@*='col-12 mt-4 col-md-6']")).isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());

        //New Tab butonuna click yap
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        Assert.assertTrue(driver.findElement(By.id("sampleHeading")).getText().contains("This is a sample page"));

        //İlk Tab'a geri dön
        driver.switchTo().window(allWindow.get(0));

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='tabButton']")).isDisplayed());



    }
}
