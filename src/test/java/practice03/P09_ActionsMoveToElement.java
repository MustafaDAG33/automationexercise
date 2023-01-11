package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P09_ActionsMoveToElement extends TestBase {


    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dil = driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-discoverability-t1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dil).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[.='Change country/region.'])[1]")).click();
        waitFor(3);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select option = new Select(dropDown);
        option.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("//*[@id='icp-dropdown-item-18']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));

    }




}
