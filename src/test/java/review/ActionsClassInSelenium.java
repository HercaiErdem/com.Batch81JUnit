package review;

public class ActionsClassInSelenium {
    /*
    TestNg, JUnit, Cucumber'da Actions class’ini kullanarak mouse ve klavye
    ile yapabilecegimiz tum islevleri gerceklestirebiliriz.

    Bunun için gerçekleştireceğimiz adımlar;
    1. Actions class’ta bir object oluşturulur.
   Syntax=> Actions actions= new Actions(driver);

   2. Erişmek istenilen WebElement öğesini bulunur.
   Örneğin=> WebElement sample = driver.findElement(By.id("****"));

   3. Sonrada  bu webelement üzerinde action gerçekleştirilir. Örneğin Webelemente çift tıklayalım
     actions.doubleClick(sample).perform( );

   ** action. ın calisması icin sonuna mutlaka perform( ) eklenir.

   Action Class Örneği;
   Actions action = new Actions(driver);
   action.moveToElement(accountList).perform();
     */

    // Bazı Mouse Aksiyonlari(Mouse Base Actions)
    /*
    --> doubleClick ( ): WebElement’e çift tıklama için kullanılır.
    --> clickAndHold ( ): WebElement uzerinde click yapili şekilde komut bekler.
    --> dragAndDrop ( ): WebElement’i bir noktadan diğerine sürükler ve bırakır.
    --> moveToElement ( ): Mouse’u istenilen WebElement’in uzerinde tutmak için kullanilır.
    --> contextClick ( ): Mouse ile istenilen WebElement’e sag tiklamal için kullanılır.
     */



}
