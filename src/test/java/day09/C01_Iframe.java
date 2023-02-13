package day09;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C01_Iframe {

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
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
    public void tearDown() {
        //  driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement ıframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(ıframeYazisi.isDisplayed());
        System.out.println(ıframeYazisi.getText());

        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement texBox = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(texBox); // texbox in icine gectik, Frame e gecis yapmadan once
        // orayi id ile locate edelim. Sonra locate ettigimiz frame
        // e bu method() u kullaniliz.
        WebElement texBoxFrame = driver.findElement(By.xpath("//p"));
        texBoxFrame.clear(); // clear method u() texbox in icini temizler
        Thread.sleep(2000);
        texBoxFrame.sendKeys("Merhaba Dunya!");

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugu
        // dogrulayin ve konsolda yazdirin

        //frame den cikip ana html koduna gelmemiz gerek
        //Ana sayfaya gecmek icin bu method() kullanilir
        driver.switchTo().defaultContent();
        WebElement seleiumText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(seleiumText.isDisplayed());
        System.out.println(seleiumText.getText());


    }


}
