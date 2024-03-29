package day05;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C03_BeforeClassAfterClass {

    /*
  BeforeClass ve AfterClass notasyonlari kullaniyorsak
  olusturacagimiz method'u static yapmammiz gerekiyor
  */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    /*
    Calismasini istemedigimiz test icin @Ignore notasyonu yazilir
     */
    @Ignore("Ahmet'in testi, beni ilgilendirmez")
    public void method1() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://www.amazon.com");

    }

    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://www.hepsiburada.com");
    }
}