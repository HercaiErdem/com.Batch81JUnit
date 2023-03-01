package review;

import org.apache.commons.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;

public class JsExecutor02 extends TestBaseBeforeAfter {

    // 1)Cicek Sepetine gidelim https://www.ciceksepeti.com/?utm_source
    // 2)Yesil sepetine(ilkine tiklayalim)
    // 3)Sayfanin altindaki sosyal medya amblemlerine kadar scroll yapalim
    // 4)Tum sayfanin ss ini alalim


    @Test
    public void testCicekSepeti01() throws IOException {
        driver.get("https://www.ciceksepeti.com/?utm_source");
        driver.findElement(By.xpath("(//img[@height='720'])[1]")).click();
        WebElement sosyalMedyaAmblemi =
                driver.findElement(By.xpath("//ul[@class='social']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", sosyalMedyaAmblemi);
        jse.executeScript("arguments[0].click();", sosyalMedyaAmblemi);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File allPageSSCicekSepeti = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(allPageSSCicekSepeti, new File("Target/EkranGoruntusu/allpage" + tarih + ".jpeg"));

    }
}
