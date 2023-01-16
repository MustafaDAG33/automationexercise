package automation_testing03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Registration extends TestBase {


    public static void registration(String mail, String sifre){
        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.xpath("//*[.='My Account']")).click();

        Actions actions = new Actions(driver);
        actions.moveByOffset(0,0).click().build().perform();//reklami gec

        driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys(sifre);
        waitFor(2);

        driver.findElement(By.xpath("//input[@name='register']")).click();

    }

    @Test
    public void signIn() {
        registration("Crespospor17@gmail.com", "MGLcrcrsp17715577");

    }



}
