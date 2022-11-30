package review;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reviewUtilities.ReviewBeforeAfterTestBase;

public class AnimalEmojiPracticeDersi extends ReviewBeforeAfterTestBase {
    @Test
    public void test01() {
        //1) go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //2) ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement seconAnimalEmoji = driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]"));
        //3) tüm hayvan emojilerine tıklayın
        //4) formu doldurun (dilediğinizi yazabilirsiniz)
        //5) apply butonuna tıklayınız.


    }
}
