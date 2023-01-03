package automation_exercise01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class E17 extends TestBase {

    @Test
    public void removeProductsFromCart() throws InterruptedException {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        navigateUrlAndVerifyHomePage();

        //4. Sepete ürün ekleyin
        driver.findElement(By.xpath("//*[@data-product-id='2']")).click();

        //5. 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //6. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='active']")).isDisplayed());

        //7. Belirli bir ürüne karşılık gelen 'X' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        Thread.sleep(3000);

        //8. Ürünün sepetten çıkarıldığını doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='text-center']//*[.='Cart is empty!']")).isDisplayed());
    }

}
