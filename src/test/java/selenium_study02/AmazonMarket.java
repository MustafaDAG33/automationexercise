package selenium_study02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

public class AmazonMarket extends TestBase {

    @Test
    public void test01() {

        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr/");



        driver.findElement(By.id("sp-cc-accept")).click();





        //Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        //Check that the results are listed
        WebElement result = driver.findElement(By.xpath("(//div[@class='s-no-outline'])[1]"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("iphone 13 512"));

        //Click iPhone13 at the top of the list
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Log the following values for each size .Size information .Price .Color .Stock status
        //Isim - Renk - Stok - Boyut - Fiyat


        //WebElement iphone512 = driver.findElement(By.xpath("//span[@id='size_name_2-announce']"));
        //WebElement iphone256 = driver.findElement(By.xpath("//span[@id='size_name_1-announce']"));

        try{
            WebElement ip =   driver.findElement(By.xpath("//span[@id='size_name_0']"));
            for (int i = 0; i < 3; i++) {

                driver.findElement(By.xpath("//span[@id='size_name_" + i + "']")).click();
                waitFor(3);

                WebElement iphoneTitle = driver.findElement(By.xpath("//*[@id='productTitle']"));
                System.out.println(iphoneTitle.getText());

                WebElement price = driver.findElement(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']"));
                System.out.println("price = " + price.getText());

                WebElement color = driver.findElement(By.xpath("//*[@id='inline-twister-expanded-dimension-text-color_name']"));
                System.out.println("color = " + color.getText());

                WebElement size = driver.findElement(By.xpath("//*[@id='inline-twister-expanded-dimension-text-size_name']"));
                System.out.println("size = " + size.getText());

                WebElement stok = driver.findElement(By.xpath("//div[@id='availability']"));
                System.out.println("stok = " + stok.getText());


            }

        }catch (Exception e){

            try{
                for(int i=1; i<4; i++ ){
                    WebElement ip1 =    driver.findElement(By.xpath("//*[@id='a-autoid-11']"));

                    driver.findElement(By.xpath("//*[@id='a-autoid-1"+i+"']"));
                    waitFor(5);
                    WebElement iphoneTitle1 = driver.findElement(By.xpath("//*[@id='productTitle']"));
                    System.out.println(iphoneTitle1.getText());

                    WebElement price1 = driver.findElement(By.xpath("//*[@id='corePriceDisplay_desktop_feature_div']"));
                    System.out.println(price1.getText());

                    WebElement color1 =   driver.findElement(By.xpath("(//span[@class='selection'])[2]"));
                    System.out.println(color1.getText());

                    WebElement size1 =   driver.findElement(By.xpath("(//span[@class='selection'])[1]"));
                    System.out.println(size1.getText());

                    WebElement stok1 = driver.findElement(By.xpath("//div[@id='availability']"));
                    System.out.println(stok1.getText());
                }


            }catch (Exception d){
                System.out.println("Sayfaya ulasilamadi");
            }




        }























    }



}
