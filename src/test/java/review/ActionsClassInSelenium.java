package review;

public class ActionsClassInSelenium {
    /*
    TestNg, JUnit, Cucumber'da Actions Class’ini kullanarak gerçekte mouse ve klavye
    ile yapabildiğimiz tum islevleri gerceklestirebiliriz.

    Bunun için yapmamız gereken adımlar;
    1. Actions class’ta bir object oluştururuz.
   Syntax=> Actions actions= new Actions(driver);

   2. Erişmek istenilen WebElement öğesini bulunuz.
   Örneğin=> WebElement sample = driver.findElement(By.id("****"));

   3. Sonra da  bu webelement üzerinde "action" gerçekleştiririz. Örneğin Webelemente çift tıklamak için
     actions.doubleClick(sample).perform( );

   ** action. ın calışması icin sonuna mutlaka .perform( ) eklenir.

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
