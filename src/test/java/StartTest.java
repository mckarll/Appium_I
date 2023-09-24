import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.net.MalformedURLException;

public class StartTest extends BaseClass {

    public static void main(String[] args) throws Exception {

        setUp();

        System.out.println("StartTest");
        driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        Thread.sleep(10000);



        tearDown();



    }

}
