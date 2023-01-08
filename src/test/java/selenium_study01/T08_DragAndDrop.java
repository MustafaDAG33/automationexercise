package selenium_study01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T08_DragAndDrop extends TestBase {

    @Test
    public void test01() {

        //   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        //  #Ülkeye göre başkentleri doldurun
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions = new Actions(driver);

        for(int i=1; i<8; i++){
            WebElement source = driver.findElement(By.id("box"+i));
            WebElement target = driver.findElement(By.id("box10"+i));
            actions.dragAndDrop(source,target).release().build().perform();
            waitFor(2);
        }


    }
}
