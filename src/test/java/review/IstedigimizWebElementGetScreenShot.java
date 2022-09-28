package review;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class IstedigimizWebElementGetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //BestBuy a gidelim
        driver.get("https://www.bestbuy.com");
        //HELLO! yazisinin resmini alalim
        WebElement helloWord = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        File helloWordGetScreenShot = helloWord.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(helloWordGetScreenShot,new File("target/ekranGoruntusuWE/WESS"+tarih+".jpeg"));




    }
}
