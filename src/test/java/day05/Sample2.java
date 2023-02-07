package day05;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class Sample2 {

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
        // Thread.sleep(1000);
        // driver.close();
    }

    @Test
    public void method() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        WebElement aramaTusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaTusu.sendKeys("Winter Dress", Keys.ENTER);
    }
}
