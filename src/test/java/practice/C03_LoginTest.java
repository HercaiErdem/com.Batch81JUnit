package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {

    // https://www.koalaresorthotels.com/ sayfasina gidiniz

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1() throws InterruptedException {
        // https://www.koalaresorthotels.com/ sayfasina gidiniz
        driver.get("https://www.koalaresorthotels.com/");
        // Login butonuna tikla
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();
        //Login ekranina girdiginizi 4 farkli elementi kullanarak dogrulayin
        //1.
        Assert.assertTrue("Login ekranina giris yapilmadi", driver.getTitle().contains("Log in"));
        //2.
        String expectedUrl = "https://www.koalaresorthotels.com/Account/Logon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Login ekranina giris yapilmadi", expectedUrl, actualUrl);
        // 3.
        WebElement usernameBox = driver.findElement(By.xpath("//input[@id='UserName']"));
        Assert.assertTrue(usernameBox.isDisplayed());
        // 4.
        WebElement categoriesYazisi = driver.findElement(By.xpath("(//h3)"));
        Assert.assertTrue("Categories sayfa da gozukmuyor",
                categoriesYazisi.isDisplayed());

    }
}
