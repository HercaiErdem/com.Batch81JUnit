package day16;

import org.apache.commons.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;


public class C01_GetScreenShotWebElement extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //Arama sonucu yazisinin resmini aratalim
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        // Sadece web elementin resmini alacaksak; TakeScreenShot classini kullanmama gerek yok,
        // Locate ettigimiz web elementi direkt gecici bir file a atip FileUtils ile kopyalayip yolunu(path) belirtiriz.
        FileUtils.copyFile(nutellaAramaSonucu, new File("target/ekranGoruntusuWE/WEESS" + tarih + ".jpeg"));


    }
}
