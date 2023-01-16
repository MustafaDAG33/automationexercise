package selenium_study02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class N11_DecisionTable extends TestBase {


    public static void n11DecisionTable(String mail,String psw){
        driver.get("https://www.n11.com/");
        waitFor(3);
        driver.findElement(By.xpath("//a[@title='Giriş Yap']")).click();
        waitFor(3);

        driver.findElement(By.xpath("//input[@id='email']")).
        sendKeys(mail, Keys.TAB,psw);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        //driver.findElement(By.id("loginButton")).click();
        if(driver.findElement(By.id("loginButton")).isEnabled()){
            driver.findElement(By.id("loginButton")).click();
        }

        waitFor(5);


    }

    @Test
    public void test01() {
        n11DecisionTable("test.123.yap@gmail.com","Deneme123!");

    }





}
