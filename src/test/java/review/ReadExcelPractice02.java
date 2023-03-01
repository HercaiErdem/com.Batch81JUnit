package review;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;

import java.io.*;

public class ReadExcelPractice02 {

    @Test
    public void readExcelTest1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-Ingilizce baskentler sutununu yazdiralim
        int lastRow = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(lastRow);
        String englishCapitalCity = "";

        for (int i = 0; i <= lastRow; i++) {
            englishCapitalCity = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(englishCapitalCity);

        }


    }
}
