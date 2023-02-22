package practice;

import org.junit.*;

public class C02_JUnit {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
        // Her class dan once calisir, 1 defa calisir
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Before
    public void before() {
        System.out.println("Before");
        // Her text den once calisir
    }

    @After
    public void after() {
        System.out.println("After");
        // Her test'ten once calisir
    }

    @Test
    public void test01() {
        System.out.println("Test01");
    }

    @Test
    public void test02() {
        System.out.println("Test02");
    }

    @Test
    public void best03() {
        System.out.println("best03");
    }

}
