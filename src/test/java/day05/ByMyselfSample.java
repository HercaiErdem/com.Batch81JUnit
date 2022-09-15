package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ByMyselfSample {

    /*
    1)Techproeducation'un lms sayfasina git https://lms.techproeducation.com
    2) TechproEducation yazisinin başarıyla görünür olduğunu doğrulayın
    3) Login tusuna tikla
    4) Username e ismini gir
    5) Password e sifreni gir
    username = "hercaierdem27@gmail.com"
    7) password= *******
    8)login tusuna tikla
    9)Login to your account yazisini yazdir
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
    public void tearDown() throws InterruptedException {
        //    Thread.sleep(2000);
        //  driver.close();
    }

    @Test
    public void method() throws InterruptedException {
        //1)Techproeducation'un lms sayfasina git https://lms.techproeducation.com
        driver.get("https://lms.techproeducation.com");

        //2) TechproEducation yazisinin başarıyla görünür olduğunu doğrulayın
        //    WebElement techproEducationYazisi= driver.findElement(By.xpath("(//img[@class='logo1 img-fluid'])"));
        //  if (techproEducationYazisi.isDisplayed()){
        //    System.out.println("TechproEducation yazisi testi PASSED");
        // }else System.out.println("TechproEducation yazisi testi FAILED");

        if (driver.findElement(By.xpath("(//img[@class='logo1 img-fluid'])")).isDisplayed()) {
            System.out.println("TechproEducation yazisi testi PASSED");
        } else System.out.println("TechproEducation yazisi testi FAILED");


        //  3) Login tusuna tikla
        Thread.sleep(2000);
        //   WebElement loginTusu = driver.findElement(By.xpath("(//*[@class='banner-btn bdrs3'])"));
        //   loginTusu.click();
        driver.findElement(By.xpath("(//*[@class='banner-btn bdrs3'])")).click();

        //4) Username e ismini gir
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        username.sendKeys("hercaierdem27@gmail.com");

        //5) Password e sifreni gir
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@id='password'])")).sendKeys("123223HE");

        //8)login tusuna tikla
        Thread.sleep(1000);
        // driver.findElement(By.id("loginbtn")).click();
        WebElement login2 = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
        login2.click();



    }


}



