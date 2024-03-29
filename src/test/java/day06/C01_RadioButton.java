package day06;

import io.github.bonigarcia.wdm.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.*;

public class C01_RadioButton {
    /*
    Bir class oluşturun : RadioButtonTest
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    https://www.facebook.com adresine gidin
    Cookies’i kabul edin
    “Create an Account” button’una basin
    “radio buttons” elementlerini locate edin
    Secili degilse cinsiyet butonundan size uygun olani secin
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
        //     driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        //www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //Create an Account” button’una basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

        // radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//label[@class='_58mt']"));

        //   Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(1000);
        if (!femaleButton.isSelected()) {
            femaleButton.click();
        }
    }
}
