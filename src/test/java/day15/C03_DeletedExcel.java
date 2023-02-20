package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.*;

import java.io.*;

public class C03_DeletedExcel {
    @Test
    public void delatedExcelCell() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); // Olusturmus oldugumuz dosyayi sistemde isleme alir.
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); // Workbook objesiyle fis objesi ile akisa aldigimiz
        //----> dosyamizla bir excel dosyasi creare ettik.
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // Excel dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); // Sayfa 1 deki 3. satiri bu sekilde seceriz
        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); // Satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir.
        //- 3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        Bir cell deki data yi silmek icin row objesine ihtiyac vardir.
        row objesi ile removeCell() methodunu kullanarak cell objesi ile belirttimiz cell degerini silebiliriz.
        */

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        System.out.println(cell.toString());
        fis.close();
        fos.close();
        workbook.close();


    }
}
