package day13_seleniumexceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_StaleElementReferenceException extends TestBase {

    @Test
    public void test01() {

        driver.get("https://www.techproeducation.com");
        waitFor(5);

//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);

        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(5);

//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git

    }

    @Test
    public void test02() {
        driver.get("https://techproeducation.com");

        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();//SAYFA YENİLENMEDEN ONCE BUKDUGUM ELEMENTE SATFA YENİLENDİKTEN SONRA KULLANMAK ISTEDIM.

        //        COZUM ESKI(SLATE ELEMENT) ELEMENTI TEKRAR LOCATE ET
        //        driver.findElement(By.linkText("LMS LOGIN")).click();
    }
}
