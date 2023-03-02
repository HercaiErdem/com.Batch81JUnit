package review;

import org.junit.*;
import reviewUtilities.*;

public class TestBaseBeforeAfterReview extends ReviewBeforeAfterTestBase {


    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
    }

}
         /*
       Child class in Parent class a ulaşması için “extends” keyword unu kullandık.
       Bu sayede özellik ve metotları inharence yaptik.
        */