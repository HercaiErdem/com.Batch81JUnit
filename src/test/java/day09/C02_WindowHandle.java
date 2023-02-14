package day09;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C02_WindowHandle {

    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in Best Buy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım

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
        driver.quit();
        Thread.sleep(2000);
    }

    @Test
    public void test1() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();
        /*
        Eger bize verilen task da sayfalar arasi gecis varsa her diver.get() methodundan sonra
        driver'in windiw handle degerini string bir degiskene atariz
        Sonrasinda farkli bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya donmemiz istenirse
        String degiskene atadigimiz window handle değerleriyle sayfalar arası geçiş yapabiliriz.
         */

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(exceptedUrl));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW); // Yeni bir pencere acmak icin bu method() u kullaniriz.
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        //4- title'in Best Buy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle); // Sayfalar arasi gecis icin bu method() kullanilir.
        WebElement searcbox = driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys("java", Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement arananSonuc = driver.findElement
                (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualArananKelime = driver.getTitle();
        String expectedArananKelime = "java";
        Assert.assertTrue(actualArananKelime.contains(expectedArananKelime));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        /*
        - uzun yolu-
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
         */

        //9- Sayfaları Kapatalım

    }
}
