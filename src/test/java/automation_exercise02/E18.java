package automation_exercise02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E18 extends TestBase {

    @Test
    public void viewCategoryProducts() {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3. Kategorilerin sol taraftaki çubukta göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='Category']")).isDisplayed());

        //4. 'Kadınlar' kategorisine tıklayın
        driver.findElement(By.linkText("WOMEN")).click();

        //5. "Kadınlar" kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        driver.findElement(By.linkText("DRESS")).click();
        actions.moveByOffset(0,0).click().build().perform();
        waitFor(2);
        //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - TOPS ÜRÜNLERİ' metnini onaylayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());


        //7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        driver.findElement(By.xpath("(//span[@class='badge pull-right'])[2]")).click();
        driver.findElement(By.linkText("TSHIRTS")).click();

        //8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).getText().contains("Tshirts"));

    }


}
