package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void readExcelTest1() throws IOException {

     //   Belirtilen satirNo ve sutunNo degerini parametre olarak alip o cell deki datayi konsola yazdiralim
     //   Sonucun konsolda yazilanla ayni oldugunu dogrulayin

        int satir = 12;
        int sutun = 2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
       //   Belirtilen satirNo ve sutunNo degerini parametre olarak alip o cell deki datayi konsola yazdiralim
        String actualData = workbook
                .getSheet("Sayfa1")
                .getRow(satir-1)
                .getCell(sutun-1)
                .toString();
        System.out.println(actualData);
        //Index 0 dan basladigi icin bizden istenen satira ulasmak icin bir eksigini aliriz
        String expectedData = "Baku";
        Assert.assertTrue(actualData.contains(expectedData));





    }
}
