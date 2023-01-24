package practice05;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Screenshots01 extends TestBase {

    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        waitFor(5);

        //Tüm sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        File  amazonFullScreen =    ts.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+currentTime+"image.png";

        File dosyaYolu = new File(path);

        FileUtils.copyFile(amazonFullScreen,dosyaYolu);


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        File fullSecreenTech = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentTime1 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path1 = System.getProperty("user.dir")+"/test-output/screenshots/"+currentTime1+"image.png";
        FileUtils.copyFile(fullSecreenTech, new File(path1));


        //Tekrar amazon sayfasına dönüp iphone aratalım
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(0));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Arama sonucunun resmini alalım
        WebElement searchResult = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        File result =   searchResult.getScreenshotAs(OutputType.FILE);
        String currentTime2 = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path2 = System.getProperty("user.dir")+"/test-output/screenshots/"+currentTime2+"image.png";
        FileUtils.copyFile(result, new File(path2));


    }



}
