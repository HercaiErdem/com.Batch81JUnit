package review;

import org.apache.commons.io.*;
import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

import java.io.*;

public class AllPageAndWebElementScreenShot01 extends TestBaseBeforeClassAfterClass {


    @Test
    public void test01() throws IOException {
        // hepsiburada.com a gidin https://www.hepsiburada.com
        driver.get("https://hepsiburada.com");
        // Dell Laptop aratalim
        driver.findElement(By.xpath("//*[@type='text']"))
                .sendKeys("Dell Laptop", Keys.ENTER);
        // Tum sayfanin screen shot ini alalim
        TakesScreenshot ts = (TakesScreenshot) driver;
        File AllPagePic = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(AllPagePic, new File("target/EkranGoruntusu/Allpage.jpeg"));
    }

    @Test
    public void test02() throws IOException {
        // Elektronik butonunun screen shot ini al
        WebElement electronikButton = driver.findElement
                (By.xpath("(//li[@class='sf-MenuItems-WulWXvlfIAwNiOUGY7FP'])[1]"));
        File eletronikScreenShot = electronikButton.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(eletronikScreenShot, new File("target/EkranGoruntusuWE/elektronik.jpeg"));

    }
}
