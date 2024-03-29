package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;

import java.io.*;

public class C01_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        // Excel tablosundaki tum tabloyu konsola yazdir
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tumTablo = "";
        for (int i = 0; i <= sonSatir; i++) {
            tumTablo = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString() + " ";
            System.out.println(tumTablo);

        }


    }
}
