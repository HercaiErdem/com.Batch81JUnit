package day12;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utilities.*;

import java.time.*;

public class C03_SynchronizationWait extends TestBaseBeforeAfter {
    @Test
    public void implicitlyWaittest1() {
        // Bir class olusturun : WaitTest
        // Iki tane metod olusturun : implicitWait() , explicitWait()
        // Iki metod icin de asagidaki adimlari test edin.
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButton.click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back! mesajinin gorundugunu test edin
        String actualMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
        String expectedMessage = "It's back!";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void explicitWaittest2() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        WebElement removeButton = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButton.click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement isGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back! mesajinin gorundugunu test edin
        WebElement itsBackWe = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@id='message']")));
        String expectedMessage = "It's back!";
        Assert.assertTrue(itsBackWe.isDisplayed());

                /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler

        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız

        implicitly wait testten once calsitirilir ve calistirilan testin tamamina etki eder
        explicit wait ise once obje olarak olusturulur sonra
         sadece kullanildigi yerde ve belirlenen sart a gore calisir class ya da test in tamamina uygulanmaz
         */

        /*
        İmplicitly ile her elementi Max 15 sn bekletiyoruz ama bir yerde 30 saniye beklemesi gerekiyorsa
        o zaman explicitWait kullanıyoruz
        */

    }
}
