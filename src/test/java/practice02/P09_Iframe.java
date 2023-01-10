package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P09_Iframe extends TestBase {

    @Test
    public void test01() {

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        waitFor(5);

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        driver.switchTo().defaultContent();
        // Videoyu calistirdiginizi test ediniz
        WebElement oynatKisayolu = driver.findElement(By.xpath("//button[@aria-label='Oynat klavye kısayolu k']"));
        Assert.assertTrue(oynatKisayolu.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        Assert.assertTrue(driver.findElement(By.id("Powerful_but_easy_to_misuse")).isDisplayed());

    }
}
