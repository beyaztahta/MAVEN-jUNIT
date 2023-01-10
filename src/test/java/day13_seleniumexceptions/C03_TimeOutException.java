package day13_seleniumexceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_TimeOutException extends TestBase {

/*
Explicitwait kullanip da element bulunamadigi zaman bu exception alinir.
 */
    @Test
    public void test01() {
        driver.get("https://techproeducation.com");
//        waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")), 15).
//                sendKeys("QA"+ Keys.ENTER);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlıs id")));//org.openqa.selenium.TimeoutException:
        //parametre 1. beklemek istedgim element,2. parametre max sure
    }
}
