package selenium_study;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement wd = driver.findElement(By.id("dropdown-class-example"));
        Assert.assertTrue(wd.isDisplayed());

        //3-Option3 ü seçin.
        Select opt = new Select(wd);
        opt.selectByVisibleText("Option3");

        //4-Option3 ün seçili olduğunu doğrulayın.
        WebElement actual =   opt.getFirstSelectedOption();
        String expected = "Option3";
        Assert.assertEquals(expected,actual.getText());
        driver.close();



    }



}
