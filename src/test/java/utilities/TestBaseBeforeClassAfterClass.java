package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {

    protected static WebDriver driver;
    protected static String tarih;

    @BeforeClass
    static public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHmmss");
        tarih = date.format(formater);
    }

    @AfterClass
    static public void tearDown() throws InterruptedException {
        //  Thread.sleep(2000);
        //  driver.quit();
    }
}
