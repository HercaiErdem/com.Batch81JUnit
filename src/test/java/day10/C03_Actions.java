package day10;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import utilities.*;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        // Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // Account menusunden create a list linkine tiklayalim
        WebElement accountList = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions action = new Actions(driver);
        action.moveToElement(accountList).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */

    }
}
