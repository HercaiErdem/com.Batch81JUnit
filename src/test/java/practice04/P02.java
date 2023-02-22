package practice04;

import org.junit.*;

import java.nio.file.*;

public class P02 {
    @Test
    public void verify() {
        //Verify that we have pom.xml file in our project => please try in 4 min s

        //   String path = "C:\\Batch81\\com.Batch81JUnit\\pom.xml";

        //   Assert.assertTrue(Files.exists(Paths.get(path)));

        String filePath = "C:\\Batch81\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));


    }
}
