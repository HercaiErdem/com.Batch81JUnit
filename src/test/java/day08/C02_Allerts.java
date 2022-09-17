package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sitesine girdigimizde karsimiza bir uyarı mesaji ya da bir butona
    tikladigimizda uyari cikabilir eger bu uyariya incele(mause sag tik-inspect) yapabiliyorsak
    bu tur allert lerde HTML allert denir  ve istedigimiz locate i alabiliriz.
    Ama gelen uyari kutusuna mudahale(sag tik-inspect) edemiyorsak bu tur allert lere js allert denir.
    js allertlere mudahale edebilmek icin
    - tamam ya da ok icin => driver.switchTo().alert().accept() kullanilir.
    - iptal icin => driver.switchTo().alert().dismiss() methodu kullanilir.
    - Alert icindeki mesaji almak icin --> driver.switchTo().alert().getText() kullanilir.
    - Alert bizden bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir.
     */


    /*
    Bir class olusturun: Alerts
https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
 “You successfully clicked an alert” oldugunu test edin.

Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.

Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
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
          driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        WebElement button = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        button.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // “You successfully clicked an alert” oldugunu test edin.
        WebElement mesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "You successfully clicked an alert";
        Assert.assertEquals(expectedMesaj, actualMesaj);

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        WebElement dismissMesaj = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        dismissMesaj.click();
        Thread.sleep(2000);
        //Allert uzerindeki mesaji yazdir
        System.out.println("2. Butonun Mesaji " + driver.switchTo().alert().getText());
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();

        //“successfuly” icermedigini test edin.
        WebElement ikinciMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        String actualMesaj = ikinciMesaj.getText();
        String exceptedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(exceptedMesaj));
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        Thread.sleep(2000);
        WebElement ucuncuButon = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        ucuncuButon.click();
        Thread.sleep(1000);
        //Alert uzerindeki mesaji yazdiriniz
        System.out.println("3. butonun alert mesaji" + driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Hercai");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement ucuncuMesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = ucuncuMesaj.getText();
        String expectedMesaj = "You entered: Hercai";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));


    }
}
