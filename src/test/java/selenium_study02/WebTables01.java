package selenium_study02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables01 extends TestBase {


    @Test
    public void test01() {
        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
        List<WebElement> table1 = driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tr//td[7]"));
        table1.forEach(t-> System.out.println(t.getText()));

        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        table1.forEach(t->Assert.assertTrue(t.getText().contains("@")));



    }
}
