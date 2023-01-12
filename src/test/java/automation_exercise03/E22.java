package automation_exercise03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class E22 extends TestBase {

    @Test
    public void  addToCartFromRecommendedItems() {

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Sayfanın en altına gidin
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //4. 'ÖNERİLEN ÖĞELER'in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='recommended_items']")).isDisplayed());

        //5. Önerilen üründe 'Sepete Ekle'ye tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[70]")).click();

        //6. 'Sepeti Görüntüle' düğmesine tıklayın
        driver.findElement(By.xpath("//*[.='View Cart']")).click();

        //7. Sepet sayfasında ürünün görüntülendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='product-2']")).isDisplayed());

    }
}
