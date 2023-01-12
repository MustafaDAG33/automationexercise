package automation_exercise03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class E21 extends TestBase {

    @Test
    public void addReviewOnProduct() {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        Actions actions = new Actions(driver);

        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.partialLinkText("Products")).click();
        actions.moveByOffset(0,0).click().build().perform();
        waitFor(2);

        //4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        Assert.assertTrue(driver.getTitle().contains("All Products"));

        //5. 'Ürünü Görüntüle' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[.='View Product'])[1]")).click();

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        //6. "İncelemenizi Yazın"ın görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Write Your Review']")).isDisplayed());

        //7. Adı, e-postayı girin ve gözden geçirin
        //8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Ronaldo", Keys.TAB,"Ronaldo@gmail.com",Keys.TAB,"Thanks",
                Keys.TAB,Keys.ENTER);

        //9. Başarı mesajını doğrulayın 'İncelemeniz için teşekkür ederiz.'
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Thank you for your review.']")).isDisplayed());


    }
}
