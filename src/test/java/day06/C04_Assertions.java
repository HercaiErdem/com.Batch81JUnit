package day06;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C04_Assertions {

    /*
      https://www.youtube.com adresine gidin
      Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
      titleTest => Sayfa başlığının “YouTube” oldugunu test edin
      imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
      Search Box 'in erisilebilir oldugunu test edin (isEnabled())
      wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() {
        // titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test2() {
      // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }

    @Test
    public void test3() {
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[3]")).isEnabled());
    }

    @Test
    public void test4() {
       // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String unExpectedTitle = "youtube";
        Assert.assertNotEquals(unExpectedTitle, actualTitle);
    }
}