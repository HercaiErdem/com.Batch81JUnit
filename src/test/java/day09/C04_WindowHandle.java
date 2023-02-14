package day09;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;
import java.util.*;

public class C04_WindowHandle {
    /*
   Tests package’inda yeni bir class olusturun: WindowHandle2
   https://the-internet.herokuapp.com/windows adresine gidin.
   Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
   Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
   Click Here butonuna basın.
   Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
   Sayfadaki textin “New Window” olduğunu doğrulayın.
   Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
    */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String birinciWebSayfa = driver.getWindowHandle();
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement
                (By.xpath("//*[text()='Opening a new window']")).isDisplayed());
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        /*
       Bir web sitesine gittigimizde bir webelementi tikladigimizda yeni bir sekme ya da pencere acilirsa
       bu yeni acilan sekmenin handle degerini bulabilmek icin driver.getWindowHandles() methodunu
       bir ArrayList'e atip butun sayfalarin listesine ulasabiliriz. Ilk actigim pencerenin index'i 0'dır,
       ikinci acilan sekmenin index'i 1'dir ve ikinci acilan pencere veya sekmede islem yapabilmek icin
       driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
         */
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle = driver.getTitle();
        String expectedTile = "New Window";
        Assert.assertEquals(expectedTile, actualTitle);
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(birinciWebSayfa);
        //driver.switchTo().window(windowList.get(0))
        Thread.sleep(2000);
        String actualBirinciSayfaninTitle = driver.getTitle();
        String expectedBirinciSayfaninTitle = "The Internet";
        Assert.assertEquals(expectedBirinciSayfaninTitle, actualBirinciSayfaninTitle);

    }
}
