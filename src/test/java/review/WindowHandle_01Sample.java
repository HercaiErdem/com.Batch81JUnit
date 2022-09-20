package review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandle_01Sample {

    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in Best Buy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım

    static WebDriver driver;

    @BeforeClass
    static public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        String actualAmazonUrl = driver.getCurrentUrl();
        String expectedAmazonUrl = "amazon";
        Assert.assertTrue(actualAmazonUrl.contains(expectedAmazonUrl));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        //4- title'in Best Buy içerdiğini test edelim
        String actualBestBuyTitle = driver.getTitle();
        String expectedBestBuyTitle = "Best Buy";
        Assert.assertTrue(actualBestBuyTitle.contains(expectedBestBuyTitle));
        //5- İlk sayfaya dönüp sayfada java aratalım
        Thread.sleep(2000);
        driver.switchTo().window(amazonWindowHandle);
        //6- Arama sonuclarının java içerdiğini test edelim
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);
        WebElement aramaSonucu = driver.findElement
                (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualAramaSonucu = driver.getTitle();
        String expectedAramaSonucu = "java";
        Assert.assertTrue(actualAramaSonucu.contains(expectedAramaSonucu));
        //7- Yeniden bestbuy sayfasına gidelim
        Thread.sleep(2000);
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        //9- Sayfaları Kapatalım
        Thread.sleep(1000);
        driver.quit();
    }
}
