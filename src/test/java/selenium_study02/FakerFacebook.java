package selenium_study02;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class FakerFacebook extends TestBase {

    @Test
    public void test01() {

        //Faker Kutuphanesi HOMEWORK
        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement hesap = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
//        js.executeScript("arguments[0].click()", hesap);


        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“create new account”  butonuna basin

        Faker faker = new Faker();

        //“firstName” giris kutusuna bir isim yazin
        String firstName = faker.name().firstName();

        //“surname” giris kutusuna bir soyisim yazin
        String surname = faker.name().lastName();

        //“email” giris kutusuna bir email yazin
        String email = faker.internet().emailAddress();

        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        String psword =   faker.internet().password();

        driver.findElement(By.name("firstname")).sendKeys(firstName, Keys.TAB,surname, Keys.TAB,email,Keys.TAB,email,Keys.TAB,psword );

        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin

        Select day = new Select(driver.findElement(By.name("birthday_day")));
        day.selectByVisibleText("7");

        Select month = new Select(driver.findElement(By.name("birthday_month")));
        month.selectByVisibleText("Mar");

        Select year = new Select(driver.findElement(By.name("birthday_year")));
        year.selectByVisibleText("2000");

        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
        WebElement woman = driver.findElement(By.xpath("//input[@value='1']"));
        woman.click();
        WebElement man = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement other = driver.findElement(By.xpath("//input[@value='-1']"));
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(woman.isSelected());
        Assert.assertFalse(man.isSelected());
        Assert.assertFalse(other.isSelected());

    }


}
