package day10;

import org.junit.*;
import utilities.*;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");

    }
}
