package review;

import org.apache.commons.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;

public class WebElementGetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //BestBuy a gidelim
        driver.get("https://www.bestbuy.com");
        //HELLO! yazisinin resmini alalim
        WebElement helloWord = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        File helloWordGetScreenShot = helloWord.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(helloWordGetScreenShot, new File("target/ekranGoruntusuWE/WESS" + tarih + ".jpeg"));


    }
}
