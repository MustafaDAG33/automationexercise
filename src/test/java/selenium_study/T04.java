package selenium_study;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T04 extends TestBase {



    @Test
    public void test01(){

        //   go to url :
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.partialLinkText("Alert with OK")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();


        //    accept Alert(I am an alert box!) and print alert on console
        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();


        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("Mustafa");
        driver.switchTo().alert().accept();

        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        WebElement w = driver.findElement(By.id("demo1"));
        Assert.assertTrue(w.getText().contains("Mustafa"));



    }
}
