package day14_takescreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreensShot3 extends TestBase {

    @Test
    public void test01() throws IOException {
//        Techpro education a git
        driver.get("https://techproeducation.com");

        //Logonun ekran goruntusunu alın.
        takeScreenshotOfElement(driver.findElement(By.xpath("//div[@data-id='898ce2e']")));

    }
}
