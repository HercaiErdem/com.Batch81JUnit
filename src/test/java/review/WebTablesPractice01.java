package review;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.stylesheets.LinkStyle;
import reviewUtilities.ReviewBeforeAfterClassTestBase;

import java.util.List;

public class WebTablesPractice01 extends ReviewBeforeAfterClassTestBase {

    @Test
    public void test1() {
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //Username : manager
        //Password : Manager1!
        WebElement userNameBox = driver.findElement(By.xpath("//input[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions.click(userNameBox).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!")
                .sendKeys(Keys.ENTER).perform();
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//td"));
        System.out.println("Sutun Sayisi: " + sutunSayisi.size());
        WebElement titles = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Tum basliklar: " + titles.getText());

    }
}
