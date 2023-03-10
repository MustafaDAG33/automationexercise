package automation_testing01;

import org.junit.Test;
import utilities.TestBase;


public class Test03 extends TestBase {

    //1) Tarayıcıyı açın
    //2) "http://practice.automationtesting.in/" URL'sini girin
    //3) Mağaza Menüsüne tıklayın
    //4) Şimdi Ana menü düğmesine tıklayın
    //5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
    //6) Ana sayfa yalnızca üç Gelenler içermelidir
    //7) Şimdi Gelenler'deki resme tıklayın
    //8) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
    //9) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.

    @Test
    public void test01(){

        homePageWithThreeArrivalsOnly();
        arrivals1();

    }

    @Test
    public void test02(){

        homePageWithThreeArrivalsOnly();
        arrivals2();

    }

    @Test
    public void test03(){

        homePageWithThreeArrivalsOnly();
        arrivals3();

    }



}
