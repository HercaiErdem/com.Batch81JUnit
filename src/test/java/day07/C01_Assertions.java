package day07;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.Duration;

public class C01_Assertions {

    /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @After
    public void tearDown() throws InterruptedException {
        // Thread.sleep(2000);
        //  driver.close();
    }

    @Test
    public void test1() {
        driver.get("http://automationpractice.com/index.php");

        //  Sign in butonuna basalim
        WebElement singinButonu = driver.findElement(By.xpath("//*[@class='login']"));
        singinButonu.click();

        // Email kutusuna @isareti olmayan bir mail yazip enter’a
        WebElement emailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        emailKutusu.sendKeys("HercaiSeval.gmail.com" + Keys.ENTER);

        //  bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement invalid = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalid.isDisplayed());

    }
}
