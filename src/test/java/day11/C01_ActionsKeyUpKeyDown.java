package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_ActionsKeyUpKeyDown extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //  Bir Class olusturalim KeyboardActions1
        //  https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");
        //  Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin
        //  ve Enter’a basarak arama  yaptirin
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").
                // // shift tusu otomasyon ile bu sekilde kullanılır. Shift tuşuna basmak için keyDown,
                // shift ten çıkmak için keyUp kullanılır
                sendKeys("1").sendKeys(Keys.ENTER).perform();

        //  aramanin gerceklestigini test edin
        WebElement aramaSonucu= driver.findElement
                (By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());

    }
}
