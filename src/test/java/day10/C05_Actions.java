package day10;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import utilities.*;

public class C05_Actions extends TestBaseBeforeAfter {

    //  Yeni bir class olusturalim: MouseActions2
    //  https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01() throws InterruptedException {
        //  https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.dragAndDrop(dragMe, dropHere).perform();
        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropped = driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String expectedDropped = "Dropped!";
        Assert.assertTrue(actualDropped.contains(expectedDropped));

    }

}
