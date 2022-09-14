package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {

    /*
    1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' url'sine gidin
3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
6. Adı ve e-posta adresini girin
7. 'Kaydol' düğmesini tıklayın
8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
10. 'Bültenimize kaydolun!' onay kutusunu seçin.
11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
13. 'Hesap Oluştur düğmesini' tıklayın
14. 'HESAP OLUŞTURULDU!' görünür
15. 'Devam' düğmesini tıklayın
16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
17. 'Hesabı Sil' düğmesini tıklayın
18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //  1. Tarayıcıyı başlatın
        //   2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //   3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@id='slider']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("Ana Sayfa Testi PASSED");
        } else System.out.println("Ana Sayfa Testi FAILED");

        //   4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayı
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //   5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement yeniKullanici = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (yeniKullanici.isDisplayed()) {
            System.out.println("Yeni Kullanici Testi PASSED");
        } else System.out.println("Yeni Kullanici Testi FAILED");

        //   6. Adı ve e-posta adresini girin
        WebElement ad = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        WebElement eposta = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        ad.sendKeys("Hercai Sevval Erdem");
        eposta.sendKeys("hercai@gmail.com");


        //   7. 'Kaydol' düğmesini tıklayın
        //button[@data-qa='login-button']
        //   8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        //   9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //   10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //   11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //   12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //   13. 'Hesap Oluştur düğmesini' tıklayın
        //   14. 'HESAP OLUŞTURULDU!' görünür
        //   15. 'Devam' düğmesini tıklayın
        //   16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //   17. 'Hesabı Sil' düğmesini tıklayın
        //   18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın


    }


}
