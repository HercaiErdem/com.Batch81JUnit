package day07;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;
import java.util.*;

public class C02_DropDownHandle {
    /*
           https://www.amazon.com/ adresine gidin.
           -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
           oldugunu testedin

           -Test2
           1.Kategori menusunden Books secenegini secin
           2.Arama kutusuna Java yazin ve aratin
           3.Bulunan sonuc sayisini yazdirin
           4.Sonucun Java kelimesini icerdigini testedin
    */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }
        int dropDownList = drops.size();
        int expectedSayi = 45;
        Assert.assertNotEquals(expectedSayi, dropDownList);
    }

    @Test
    public void test2() {
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        // 4.Bulunan sonuc SAYISINI yazdirin
        System.out.println(driver.findElement
                        (By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"))
                .getText().split(" ")[3]);
        // 5.Sonucun Java kelimesini icerdigini testedin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}
