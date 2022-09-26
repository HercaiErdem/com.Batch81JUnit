package review;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelPractice02 {

    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-Ingilizce baskentler sutununu yazdiralim
        int lastRow = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(lastRow);
        String englishCapitalCity = "";

        for (int i = 0; i <= lastRow; i++) {
            englishCapitalCity= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(englishCapitalCity);
        }



    }
}
