package practice04;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ScreenShot01 extends TestBase {


    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File goruntu =    ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")+"/test-output/screenshots/image.png";
        File dosyaYolu = new File(path);

        FileUtils.copyFile(goruntu,dosyaYolu);


    }




}
