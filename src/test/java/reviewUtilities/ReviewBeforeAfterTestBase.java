package reviewUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class ReviewBeforeAfterTestBase {


    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
      // Thread.sleep(2000);
      // driver.quit();
    }

    // tekrar ederken bu class i kullanicam, tekrar olsun diye
   /*
   -- Sınıflar arasında pek çok ortak özellik ve davranış bulunduğu durumlarda tasarlanan soyut sınıflardır.
   -- Kod tekrarını engelleyerek hem daha derli toplu bir görüntü sağlar hem de hata yapma riskini azaltır.
   -- Kod tekrarını engelleyerek hem daha derli toplu bir görüntü sağlar hem de hata yapma riskini azaltır.
   -- Dolayısıyla, Abstract sınıflardan nesne üretimi gerçekleştirilemez.
   -- Eğer abstract tanımlı bir sınıftan nesne üretmek isterseniz Java hata
   -- Temel sınıf oluşturma ile aynı kurallara sahiptir. Farklı olarak sınıf adı başına “abstract”
   anahtarı getirilir
   -- Soyut sınıflarda bulunan Constructor yapıları nesne üretmek için değil alt sınıflara istenilen
    özellikleri gönderebilmek için tasarlanır. Soyut sınıflardan nesne üretilemez.
   --Soyut metotlar “abstract” anahtarı ile public veya protected olacak şekilde tanımlanabilir.
   -- Alt sınıflar, extend ettikleri soyut sınıfta bulunan tüm soyut metotlara sahip olmak, yani
   bu metotları Override etmek zorundadırlar(
     */
    // Protect Access Modifier; Alt-sınıflar ve aynı pakettekiler erişebilir. Yazmasakta olurdu.


}
