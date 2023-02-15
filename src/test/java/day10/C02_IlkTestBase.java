package day10;

import org.junit.*;
import utilities.*;

public class C02_IlkTestBase extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");

    }
}