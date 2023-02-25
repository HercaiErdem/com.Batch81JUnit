package review;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class ArrayGetText {

    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
    /*
    //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");
    //2- arama kutusunu locate edelim
    WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
    //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
    //4- Bulunan sonuc sayisini yazdiralim
    //WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
    //System.out.println(sonucYazisi.getText());
    String[] sonucYazisi = driver.findElement
                    (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
            .getText().split(" ");
        System.out.println("Samsung headphones için arama sonucu = " + sonucYazisi[2]);
    //5- Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
    //6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
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
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void terst1() throws InterruptedException {
        //  1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //  2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //  3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //  4- Bulunan sonuc sayisini yazdiralim
        // WebElement sonucSayisi = driver.findElement
        //          (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //  System.out.println("Samsung headphones icin sonuc sayisi: " + sonucSayisi.getText());

        String[] sonucSayisi = driver.findElement
                        (By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"))
                .getText().split(" ");
        System.out.println("Samsung headphones icin sonuc sayisi: " + sonucSayisi[2]);
        //  5- Ilk urunu tiklayalim
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
        //  6- Sonuctaki basligini yazdir
        //  WebElement resultBaslik = driver.findElement(By.xpath("//span[@id='productTitle']"));
        //  System.out.println("Samsung headphones in basligi: "+ resultBaslik.getText());

        // 7- Basliktaki "Galaxy " kelimesini yazdir
        String[] resultBaslik = driver.findElement(By.xpath("//span[@id='productTitle']")).getText().split(" ");
        System.out.println(resultBaslik[1]);
        //8- Baslikta "Charging Case for Ear Buds" yazisinin gozuktugunu dogrulayin
        String expectedTitle = "Charging Case for Ear Buds";
        String actualTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();

        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

}
