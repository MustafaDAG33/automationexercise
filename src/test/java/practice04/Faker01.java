package practice04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Faker01 extends TestBase {

    @Test
    public void test01() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate ediniz
        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();

        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.name("firstname"))).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("15").
                sendKeys(Keys.TAB).sendKeys("Mart").sendKeys(Keys.TAB).sendKeys("2000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).build().perform();



    }



}
