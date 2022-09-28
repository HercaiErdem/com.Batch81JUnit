package review;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class AllPageAndWebElementScreenShot01 extends TestBaseBeforeClassAfterClass {
    //hepsiburada.com a gidin https://www.hepsiburada.com
    // Dell Laptop aratalim
    // Tum sayfanin screen shor ini alalim


    @Test
    public void test01() throws IOException {
        //hepsiburada.com a gidin https://www.hepsiburada.com
        driver.get("https://hepsiburada.com");
        // Dell Laptop aratalim
        driver.findElement(By.xpath("//*[@type='text']"))
                .sendKeys("Dell Laptop", Keys.ENTER);
        // Tum sayfanin screen shor ini alalim
        TakesScreenshot ts = (TakesScreenshot) driver;
        File AllPagePic = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(AllPagePic, new File("target/EkranGoruntusu/Allpage.jpeg"));
    }

    @Test
    public void test02() throws IOException {
        //Elektronik butonunun screen shot ini al
        WebElement electronikButton = driver.findElement
                (By.xpath("(//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP'])[1]"));
        File eletronikScreenShot = electronikButton.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(eletronikScreenShot,new File("target/EkranGoruntusuWE/elektronik.jpeg"));

    }
}
