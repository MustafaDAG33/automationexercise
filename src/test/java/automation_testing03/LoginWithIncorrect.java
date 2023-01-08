package automation_testing03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class LoginWithIncorrect extends TestBase {

    @Test
    public void loginWithInCorrect() {
        //1) Tarayıcıyı açın
        //2) “http://practice.automationtesting.in/” URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//*[.='My Account']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //4) Kullanıcı adı metin kutusuna yanlış kullanıcı adı
        //girin 5) Şifre metin kutusuna yanlış şifre girin.
        //6) Oturum açma düğmesine tıklayın
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("haydar@gmail.com",
                Keys.TAB,"Haydarpasa27374849",Keys.ENTER);


        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar oturum açmanız istenmelidir
        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("A user could not be found with this email address."));
    }

    @Test
    public void loginWithEmptyPassword() {
        //1) Tarayıcıyı açın
        //2) “http://practice.automationtesting.in/” URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//*[.='My Account']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //4) Kullanıcı adı metin kutusuna geçerli kullanıcı adını girin
        //5) Şimdi şifre metin kutusuna boş şifreyi girin
        //6) Tıklayın oturum açma düğmesinde.
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("haydarpasa@gmail.com",
                Keys.TAB,Keys.TAB,Keys.ENTER);

        //7) Uygun hata görüntülenmeli (ör. Geçersiz şifre) ve tekrar oturum açmanız istenmelidir
        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Password is required."));
    }

    @Test
    public void loginWithEmptyUsername() {

        //1) Tarayıcıyı açın
        //2) “http://practice.automationtesting.in/” URL'sini girin
        driver.get("http://practice.automationtesting.in/");

        //3) Hesabım Menüsüne tıklayın
        driver.findElement(By.xpath("//*[.='My Account']")).click();
        driver.navigate().back();
        driver.navigate().forward();

        //4) Kullanıcı adı metin kutusuna boş kullanıcı adını girin
        //5) Şimdi şifre metin kutusuna geçerli şifreyi girin
        //6) Tıklayın oturum açma düğmesinde.
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Keys.TAB,
                "HaydarPasa8735y03",Keys.ENTER);

        //7) Uygun hata görüntülenmeli (ör. Geçersiz kullanıcı adı) ve tekrar giriş yapılması istenmelidir
        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(errorMessage.getText().contains("Username is required."));
    }
}
