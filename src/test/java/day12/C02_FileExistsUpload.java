package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //  Tests packagenin altina bir class oluşturun : C05_UploadFile
        //  https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //  chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız
        dosya yolumuzu göndeririz.
         */
        //  Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\Kayra\\Desktop\\text.txt";
        dosyaSec.sendKeys(dosyaYolu);
        //  Upload butonuna basalim.
        Thread.sleep(2000);
        driver.findElement(By.id("file-submit")).click();
        //  “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());


    }
}
