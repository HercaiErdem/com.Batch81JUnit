package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    // Yeni bir class olusturalim: MouseActions1
    // https://the-internet.herokuapp.com/context_menu sitesine gidelim
    // 3- Cizili alan uzerinde sag click yapalim
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
        String actualAlertYazisi = driver.switchTo().alert().getText();

        //Allert uzerindeki yaziyi; driver.switchTo().alert().getText(); boyle aliriz

        String expectedAlertYazisi = "You selected a context menu";
        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);
        Thread.sleep(2000);
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        WebElement yaziLinki = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Thread.sleep(1000);
        yaziLinki.click();
        //yeni sayfa acildi o yuzden List e acip index ini alacagiz
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",
                driver.findElement(By.xpath("//h1")).getText());

    }
}
