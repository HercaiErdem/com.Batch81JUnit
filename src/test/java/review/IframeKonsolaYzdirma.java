package review;

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

public class IframeKonsolaYzdirma {
    /*
    Bir class olusturun: IframeTest
    https://the-internet.herokuapp.com/iframe adresine gidin.
    Bir metod olusturun: iframeTest
       “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       Text Box’a “Merhaba Dunya!” yazin.
       TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
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

    @Test
    public void tesr1() throws InterruptedException {
        //   https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement title = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(title.isDisplayed());
        System.out.println(title.getText());
        //   Text Box’a “Merhaba Dunya!” yazin.
        WebElement texBox = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(texBox);
        WebElement yaziIframe = driver.findElement(By.xpath("//p"));
        Thread.sleep(1000);
        yaziIframe.clear();
        Thread.sleep(1000);
        yaziIframe.sendKeys("Merhaba Dunya!");
        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement seleniumTest = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumTest.isDisplayed());
        System.out.println(seleniumTest.getText());
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }


}
