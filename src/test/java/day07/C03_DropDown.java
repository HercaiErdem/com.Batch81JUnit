package day07;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;

public class C03_DropDown {

    /*
          ●https://www.amazon.com/ adresine gidin.
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
    Select select;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        /*
        Dropdown menuye ulasmak için Select classından bir obje oluştururuz
        ve locate ettiğimiz dropdown weblementini Select classına tanımlarız
        ve getOption methodunu kullanarak dropdown'u bir list'e atarak dropdawn menunun bütün elemanlarının
        sayısına ulaşabiliriz
         */
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi = 45;
        int actualDds = ddmList.size();
        Assert.assertNotEquals(expectedSayi, actualDds);
    }

    @Test
    public void test2() {
        //1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);

        //select.selectByVisibleText("Books"); // Eğer Dropdown menudeki option'a string olarak ulaşmak istersek bu methodu kullanırız
        //select.selectByIndex(5); // Eğer dropdown menusünun index'i ile ulasmak istersek bu methodu kullanırız
        select.selectByValue("search-alias=stripbooks-intl-ship"); // Eğer dropdown menusundeki optiona value ile ulaşmak istersek bu methodu kullanırız
         /*
        Dropdown menude seçtiğimiz optiona ulaşmak istersek select.getFirstSelectedOption()
        methodunu kullanırız
         */
        System.out.println(select.getFirstSelectedOption().getText());
        // 2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        // 4.Sonucun Java kelimesini icerdigini test edin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

    }
}