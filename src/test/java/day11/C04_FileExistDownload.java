package day11;

import org.junit.*;

import java.nio.file.*;

public class C04_FileExistDownload {

    @Test
    public void test1() {
        System.out.println(System.getProperty("user.dir"));
        //Suanki içinde bulunduğum yolu gösterir
        System.out.println(System.getProperty("user.home"));
        //Geçerli kullanıcının ana dizinini verir

        /*
        String farkliBolum = System.getProperty("user.home");
        //"C:\Users\Lenovo\OneDrive\Masaüstü\text.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = "\\OneDrive\\Masaüstü\\tex.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\Lenovo\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
       */

        String dosyaYolu = "C:\\Users\\Kayra\\Desktop\\test.txt";
        //   System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        // dosya var mi yok mu bakta gel :) kisacasi

        /*
        Bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada orda olduğunu
        test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ klik yapıp dosyanın yolunu kopyalayıp
        bir string değişkene atarız ve dosyayı doğrulamak için
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanırız
         */

    }
}
