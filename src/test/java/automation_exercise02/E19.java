package automation_exercise02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E19 extends TestBase {

    @Test
    public void viewCartBrandProducts() {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.partialLinkText("Products")).click();
        Actions actions = new Actions(driver);
        actions.moveByOffset(0,0).click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        waitFor(1);

        //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='brands_products']")).isDisplayed());

        //5. Herhangi bir marka adına tıklayın
        driver.findElement(By.partialLinkText("POLO")).click();

        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("Polo"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']")).isDisplayed());

        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.partialLinkText("H&M")).click();

        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        Assert.assertTrue(driver.getTitle().contains("H&M"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']")).isDisplayed());

    }
}
