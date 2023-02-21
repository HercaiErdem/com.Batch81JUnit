package day16;

import org.junit.*;
import org.openqa.selenium.*;
import utilities.*;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Asagidaki carrers butonunu gorunceye kadar js ile scrol yapalim
        WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", careers);
        //Carres butonuna click yapalim
        jse.executeScript("arguments[0].click();", careers);


    }
}
