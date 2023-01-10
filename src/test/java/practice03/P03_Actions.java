package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

        /*
                                            Actions
            Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
            Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
        */

    @Test
    public void test01() {

        //http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement maviKutu = driver.findElement(By.xpath("//div[@id='div2']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(maviKutu).perform();
        waitFor(3);

        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement doubleClickButton = driver.findElement(By.name("dblClick"));
        actions.doubleClick(doubleClickButton).perform();

        String alertYazisi =   driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!",alertYazisi);

        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement dragg = driver.findElement(By.id("draggable"));
        WebElement dropp = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragg,dropp).perform();

        WebElement droppedYazisi = driver.findElement(By.xpath("//*[.='Dropped!']"));
        Assert.assertEquals("Dropped!",droppedYazisi.getText());

    }




}
