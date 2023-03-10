package selenium_study01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T09_HoverOver extends TestBase {

    @Test
    public void hoverOverTest() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//button[.='Hover Over Me First!']"))).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleButton = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleButton).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        WebElement yesil =    driver.findElement(By.xpath("//*[@class='div-double-click double']"));
        Assert.assertTrue(yesil.isEnabled());
    }
}
