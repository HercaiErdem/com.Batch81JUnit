package day11;

import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.nio.file.*;

public class C05_FileExistsDownload extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // test.txt dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='test.txt']")).click();
        // Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Kayra\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // Indirildigini konsolda goster
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }
}
