package automation_testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test01 extends TestBase {

    @Test
    public void sliders(){

        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.xpath("//a[.='Shop']")).click();

        driver.navigate().back();
        driver.navigate().forward();

        driver.findElement(By.xpath("//a[.='Home']")).click();

        driver.navigate().back();
        driver.navigate().forward();

        //driver.findElement(By.xpath("//span[@class='ns-xjjx9-e-8']")).click();

        List<WebElement> sliderList = driver.findElements(By.xpath("//*[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']"));
        Assert.assertEquals(3,sliderList.size());





    }
}
