package automation_exercise03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class E20 extends TestBase {


    @Test
    public void girisYaptiktanSonraUrunleriArayinveSepetiDogrulayin() {

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

        //5. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        driver.findElement(By.id("search_product")).click();
        driver.findElement(By.id("search_product")).sendKeys("Tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        //6. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

        //7. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']")).isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //8. Bu ürünleri sepete ekleyin
        List<WebElement> addToCart = driver.findElements(By.xpath("//*[.='Add to cart']"));

        for(int i=0; i<addToCart.size(); i=i+2){

            addToCart.get(i).click();
            waitFor(1);
            driver.findElement(By.xpath("//*[.='Continue Shopping']")).click();

        }

        //9. 'Sepet' düğmesine tıklayın ve ürünlerin sepette göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[.=' Cart']")).click();
        Assert.assertTrue(driver.findElement(By.id("cart_info")).isDisplayed());

        //10. 'Kaydol / Giriş Yap' düğmesini tıklayın ve giriş bilgilerini gönderin
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Ronaldo@gmail.com", Keys.TAB,"7777",Keys.ENTER);

        //11. Tekrar Sepet sayfasına gidin
        driver.findElement(By.xpath("//*[.=' Cart']")).click();

        //12. Giriş yaptıktan sonra bu ürünlerin de sepette göründüğünü doğrulayın.
        Assert.assertTrue(driver.findElement(By.id("cart_info")).isDisplayed());

    }


}
