package practice04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Faker02 extends TestBase {

    /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */



    @Test
    public void testFaker() {

        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        // Formu doldurunuz
        // Sayfayi kapatin

        String path = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\Blue and White Abstract Technology LinkedIn Banner.png";


        driver.get("https://demoqa.com/automation-practice-form");
        waitFor(5);
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,faker.internet().emailAddress(),Keys.TAB,
                Keys.SPACE,Keys.TAB,"1234567899",Keys.TAB,"20 Jul 1980",Keys.ENTER,Keys.TAB,"hahahha",Keys.TAB,Keys.SPACE);

                //,Keys.TAB,
                //Keys.TAB,Keys.TAB,Keys.ENTER,path,Keys.ENTER,   Keys.TAB,faker.address().fullAddress(),Keys.TAB);

        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys(path);

        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress(),Keys.TAB,"Haryana",Keys.ENTER,Keys.TAB);

                //,Keys.TAB,"Karnal",
                //Keys.TAB,Keys.ENTER);
        waitFor(15);

        WebElement city =driver.findElement(By.xpath("//div[@id='city']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(city));
        city.click();
        city.sendKeys("Karnal");



        //driver.findElement(By.xpath("//div[@id='city']")).sendKeys("Karnal",Keys.TAB,Keys.TAB,Keys.ENTER);




    }



}
