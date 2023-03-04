package utilities;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;
import java.time.format.*;

public abstract class TestBaseBeforeAfter {

    protected WebDriver driver;
    protected String tarih;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHmmss");
        tarih = date.format(formater);
    }

    @After
    public void tearDown() throws InterruptedException {
        //  Thread.sleep(2000);
        //  driver.quit();

    }
}
