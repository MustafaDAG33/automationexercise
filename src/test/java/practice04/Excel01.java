package practice04;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel01 {


    @Test
    public void test01() throws IOException {

        String path = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\QA Team_06.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(1);
        System.out.println(row);


        Cell cell =    sheet.getRow(0).getCell(1);
        System.out.println(cell);


        //2. Excelde bulunan butun mail ve sifre ile sisteme giris yapildigini dogrulayan dinamik bir method olusturun.
        //3.  Exceldeki tablodaki isimler icin de  "Turuncu" olup olmadigini test edin.
        //4. Sistemde olan kisilerin ad ve soyadlarini yazdiran diamik bir method  olusturun.
        //5.  ? olan hucreye "Age" olarak ekleyin, ve asagidaki yaslari girin.
        //    Yesil=27
        //    Mavi=25
        //    Turuncu=35
    }

}
