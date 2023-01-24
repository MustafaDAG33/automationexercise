package practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebTables01 extends TestBase {


    @Test
    public void test01() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        List<WebElement> otelBilgileri = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelBilgileri.forEach(t-> System.out.println(t.getText()));

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        int row=1;
        for(WebElement w:otelBilgileri){
            if(w.getText().contains("601m")){
                System.out.println(row+"satirdaki otel bilgileri"+w.getText());
            }
            row++;
        }

        //Bütün Height bilgilerini yazdırınız
        List<WebElement> height = driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        height.forEach(t-> System.out.println(t.getText()));

        //Otel uzunluklarının hepsini toplayınız

        //Bir method ile satır ve sutun bilgilerini çağıralım

    }

}
