package selenium_study02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class KeybordActions01 extends TestBase {

    @Test
    public void test01() {

        //Bir Class olusturalim KeyboardActions2
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        waitFor(10);

        //video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();


        WebElement iframe = driver.findElement(By.xpath("//div[@class='render']/iframe"));
        driver.switchTo().frame(iframe);


        //videoyu izlemek icin Play tusuna basin

        driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay']//button[@aria-label='Oynat']")).click();
        waitFor(5);

        //videoyu calistirdiginizi test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).isDisplayed());

    }

    @Test
    public void test02() {

        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");

        //Link 1" e tiklayin
        WebElement hoverLink = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverLink).perform();
        driver.findElement(By.xpath("//*[.='Link 1']")).click();


        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //“Click and hold" kutusuna basili tutun
        WebElement clickBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickBox).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement wellDone = driver.findElement(By.xpath("//*[.='Well done! keep holding that click now.....']"));
        System.out.println(wellDone.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//*[.='Double Click Me!']"));
        actions.doubleClick(doubleClickMe).perform();
    }



}
