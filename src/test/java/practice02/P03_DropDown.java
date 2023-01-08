package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P03_DropDown extends TestBase {

    //https://www.cars.com/--->js executer

    @Test
    public void test01(){
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //dropdown menuyu yazdiralim,
        //1.yolla yazdirma
        List<WebElement> drop = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        drop.forEach(t-> System.out.println(t.getText()));


        //2.yolla yazdirma
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }




        //baby secelim
        //arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);


    }

}
