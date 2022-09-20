package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMBankLogin {

    // GMBANK "https://www.gmibank.com/" adresine gidin

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.gmibank.com/");

        // Sign-in butonuna tikla
        WebElement siginButton = driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]"));
        siginButton.click();
        // driver.findElement(By.xpath("(//*[@class='dropdown-toggle nav-link'])[2]")).click(); -- 2. yol WebElement e atamadan
        Thread.sleep(1000);
        WebElement signingButton2 = driver.findElement(By.xpath("//*[text()='Sign in']"));
        signingButton2.click();
        // Username: Batch81, Password: Batch81+
        Thread.sleep(1000);
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Batch81");
        WebElement password = driver.findElement(By.xpath("(//input[@id='password'])[1]"));
        password.sendKeys("Batch81+", Keys.ENTER);

        Thread.sleep(1000);
        driver.close();


    }
}
