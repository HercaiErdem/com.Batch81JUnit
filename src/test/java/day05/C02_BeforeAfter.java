package day05;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C02_BeforeAfter {
    WebDriver driver;

    @Before
    // Before notasyonu her testten önce çalışır
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1() {
        //1 defa before methodu çalışır
        driver.get("https://amazon.com");
        //1 defa da after methodu çalışır
    }

    @Test
    public void method2() {
        //1 defa before methodu çalışır
        driver.get("https://techproeducation.com");
        //1 defa da after methodu çalışır
    }

    @Test
    public void method3() {
        //1 defa before methodu çalışır
        driver.get("https://hepsiburada.com");
        //1 defa da after methodu çalışır
    }

    @After
    //After notasyonu her testten sonra çalışır
    public void tearDown() {
        driver.close();
    }
}

