package practice04;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots02 extends TestBase {

    @Test
    public void test02() throws IOException {

        driver.get("https://www.amazon.com");
        WebElement w = driver.findElement(By.id("nav-logo-sprites"));
        File amazon = w.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+currentTime+"image.png";
        File dosyaYolu = new File(path);

        FileUtils.copyFile(amazon,dosyaYolu);




    }


}
