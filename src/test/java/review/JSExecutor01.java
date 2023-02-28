package review;

import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;

public class JSExecutor01 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() throws IOException {
        //Hepsi Burada ya gidelim https://www.hepsiburada.com
        driver.get("https://www.hepsiburada.com");
        //Tek Tikla Guvenli Alisveri Butonuna kadar scoll yapalim
        WebElement tekTıklaGuvenliAlisverisButonu =
                driver.findElement(By.xpath("(//div[@class='iconContent'])[2]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", tekTıklaGuvenliAlisverisButonu);
        // ve butona tiklayalim
        jse.executeScript("arguments[0].click();", tekTıklaGuvenliAlisverisButonu);

        // ss ini alalim
        //  File butonWebElementiSS = tekTıklaGuvenliAlisverisButonu.getScreenshotAs(OutputType.FILE);
        //  FileUtils.copyFile(butonWebElementiSS,new File
        //          ("target/EkranGoruntusuWE/02"+tarih+".jpeg"));


    }
}
