package practice03;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookies extends TestBase {

            /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test01() {

        //Techproeducation adresine gidiniz
        driver.get("https://www.techproeducation.com");
        waitFor(5);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> allCookies =    driver.manage().getCookies();
        int cookieSayisi =  allCookies.size();
        System.out.println("cookieSayisi = " + cookieSayisi);

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for(Cookie w: allCookies){
            System.out.println("name = " +   w.getName());
            System.out.println("Value = " + w.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie yeniCookie = new Cookie("fenerbahceli futbolcu", "crespo");
        driver.manage().addCookie(yeniCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> allCookies1 = driver.manage().getCookies();
        int tumCookie = allCookies1.size();
        System.out.println("Cookie sayisi = " + tumCookie);

        for(Cookie w: allCookies1){
            System.out.println("name = " +   w.getName());
            System.out.println("Value = " + w.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(yeniCookie);

        Set<Cookie> allCookies2 = driver.manage().getCookies();
        System.out.println("allCookies2.size() = " + allCookies2.size());

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();

        Set<Cookie> allCookies3 = driver.manage().getCookies();
        System.out.println("allCookies3.size() = " + allCookies3.size());

    }





}
