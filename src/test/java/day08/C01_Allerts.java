package day08;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C01_Allerts {
    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    - Click for js Allert butonuna tiklayalim
    - Tikladiktan sonra cikan uyari mesajina (allert e) tamam diyelim
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
    public void test1() throws InterruptedException {

        //- https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //- Click for js Allert butonuna tiklayalim
        WebElement button = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        button.click();

        //- Tikladiktan sonra cikan uyari mesajina (allert e) tamam diyelim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
