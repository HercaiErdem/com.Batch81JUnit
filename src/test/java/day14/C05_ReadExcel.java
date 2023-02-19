package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;

import java.io.*;

public class C05_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 4 oldugunu test edin
        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonSatir);
        int expectedLastRow = 6;
        Assert.assertEquals(expectedLastRow, sonSatir + 1);
        int kullanilanSatir = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        //Excel tablosunda kullanilan satir sayisini bu method() ile aliriz
        System.out.println(kullanilanSatir);
        int expectedKullanilanSatir = 4;
        Assert.assertEquals(expectedKullanilanSatir, kullanilanSatir + 1);

        // lastRow --> en son yazilan satir
        //Physical --> kullanilan satir sayisi


    }
}
