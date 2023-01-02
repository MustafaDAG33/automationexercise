package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class T07_WindowHandle extends TestBase {

    @Test
    public void testWindowHandle() throws InterruptedException {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        String window1 =  driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        WebElement frameButton =  driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",frameButton);


        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement w = driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
        Assert.assertTrue(w.isDisplayed());


        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        WebElement browserWindows = driver.findElement(By.xpath("//span[.='Browser Windows']"));
        js.executeScript("arguments[0].click()",browserWindows);


        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab =  driver.findElement(By.xpath("//button[.='New Tab']"));
        Assert.assertTrue(newTab.isDisplayed());


        //New Tab butonuna click yap
        js.executeScript("arguments[0].click()",newTab);


        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Set<String> allWindows = driver.getWindowHandles();

        for(String eachwindow : allWindows){
            if(!eachwindow.equals(window1)){
                driver.switchTo().window(eachwindow);
                break;
            }
        }
        WebElement yazi =  driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(yazi.isDisplayed());


        //İlk Tab'a geri dön
        driver.switchTo().window(window1);

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());

    }
}
