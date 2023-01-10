package day13_seleniumexceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_NoSuchElementException extends TestBase {
    @Test
    public void test01() {

        driver.get("https://techproeducation.com");
        driver.
                findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:
                sendKeys("QA"+ Keys.ENTER);

    }
}
