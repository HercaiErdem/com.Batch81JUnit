package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Homework {
    // 1.satirdaki 2.hucreye gidelim ve yazdiralim
    //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    //Satir sayisini bulalim
    //Fiziki olarak kullanilan satir sayisini bulun
    //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
    @Test
    public void test1() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        // 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = ((Sheet) sheet).getRow(0);
        Cell cell = row.getCell(1);
        System.out.println(cell);
        //1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String birinciSatirikinciHucre = cell.toString();
        System.out.println(birinciSatirikinciHucre);
        //2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        String expecttedAfganistanBaskenti = "Kabil";
        String actualIkinciSatirDorduncuHucre = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println(actualIkinciSatirDorduncuHucre);
        Assert.assertEquals(actualIkinciSatirDorduncuHucre, expecttedAfganistanBaskenti);
        //Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satir Sayisi = " + satirSayisi);
        //Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatir = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir = " + kullanilanSatir);
        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        int rowCount = sheet.getLastRowNum();
        Map<String, String> mapList = new LinkedHashMap<>();
        for (int i = 0; i <= rowCount; i++) {
            row = sheet.getRow(i);
            Cell keyCell = row.getCell(0);
            String key = keyCell.getStringCellValue();
            Cell valuCell = row.getCell(1);
            String value = valuCell.getStringCellValue();
            mapList.put(key, value);
        }
    }
}
