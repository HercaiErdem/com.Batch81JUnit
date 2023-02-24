package review;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import reviewUtilities.*;

import java.util.*;

public class ActionsReview02 extends ReviewBeforeAfterTestBase {

    // Yeni bir class olusturalim: MouseActions1
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // Cizili alan uzerinde sag click yapalim
    // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    // Tamam diyerek alert’i kapatalim
    // Elemental Selenium linkine tiklayalim
    // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(cizgiliAlan).perform();
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualAllertMessage = driver.switchTo().alert().getText();
        String expectedAllertMessage = "You selected a context menu";
        Assert.assertTrue(actualAllertMessage.contains(expectedAllertMessage));
        // Tamam diyerek alert’i kapatalim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.findElement(By.xpath("//h1")).getText());


    }
}
