package review;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;

import java.io.*;

public class ReadExcelPractice01 {

    @Test
    public void readExcelTest1() throws IOException {
        // Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        // FileInputStream objesi olusturup, parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        // Workbook objesi olusturalim, parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        // Belirtilen satirNo ve sutunNo degerini parametre olarak alip o cell deki datayi konsola yazdiralim
        int satir = 8;
        int sutun = 3;

        String acualData = workbook.getSheet("Sayfa1").getRow(satir - 1).getCell(sutun - 1)
                .toString();
        System.out.println(acualData);

        //   Sonucun konsolda yazilanla ayni oldugunu dogrulayin
        String expectedResult = "Arjantin";
        Assert.assertTrue(acualData.contains(expectedResult));


    }
}
