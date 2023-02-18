package day13;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import utilities.*;

import java.util.*;

public class C03_WebTables extends TestBaseBeforeAfter {
    /*
  Bir onceki class'taki adrese gidelim
  login() methodunu kullanarak sayfaya giris yapalim
  input olarak verilen satir ve sutun sayisina sahip cell'deki texti yazdiralim
  Price basligindaki tum numaralari yazdir
  int satir = 3;
  int sutun = 4;
   */

    @Test
    public void test1() {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();
        int satir = 3;
        int sutun = 4;
        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        // WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        //   System.out.println("Satır ve sutundaki text : "+cell.getText());
        //Price başlığındaki tum numaraları yazdırınız
        List<WebElement> priceBasligi = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w : priceBasligi) {
            System.out.println(w.getText());
        }
        //--Lambda ile yazdirma---
        System.out.println("=====Lambda ile yazdirma======");
        priceBasligi.stream().forEach(t -> System.out.println(t.getText()));
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}

 //thead(Baslik)         //tr(Satir)     //th(Sutun)                   Baslik icin
 //tbody(Vucut- Ana)     //tr(Satir)      //td (Vucut - Ana Sutunu)     Body icin