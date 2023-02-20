package day15;

import org.apache.commons.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim tum sayfanın resmini alalim
        driver.get("https://bestbuy.com");
        /*
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/AllPage" + tarih + ".jpeg"));
    }

    // resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip
    // atadik
    // tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip
    // uygun hale getirdik
    // sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik


}

