package review;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import reviewUtilities.ReviewBeforeAfterClassTestBase;

public class ActionsReview01 extends ReviewBeforeAfterClassTestBase {

    // - Amazon sayfasina gidelim
    // - Account menusunden create a list linkine tiklayalim

    @Test
    public void test01() throws InterruptedException {
        // - Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // - Account menusunden create a list linkine tiklayalim
        WebElement accountBox= driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        Actions action = new Actions(driver);
        action.moveToElement(accountBox).perform();
        WebElement createAListButton = driver.findElement(By.xpath("//span[text()='Create a List']"));
        Thread.sleep(2000);
        createAListButton.click();

    }
}
