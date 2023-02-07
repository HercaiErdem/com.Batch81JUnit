package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
