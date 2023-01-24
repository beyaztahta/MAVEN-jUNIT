package day17_Jsexecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JsExecutors extends TestBase {
    //Selenium un bir parcasidir.Js Executors,javascript kodlarını java freamworkunda kullanalabilmek icin olusturulan bir API dir,interface dir..

      /*
    scrollIntoViewTest metotu olustur
    Techpro education ana sayfasina git
    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
    Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
     */

    @Test
    public void scrollIntoViewTest() throws IOException {
        // Techpro education ana sayfasina git
        driver.get("https://techproeducation.com");
        waitFor(3);

        //    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        //1.Elementi bul.
        WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));

        //2.JS executor olustur.
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //3.Yapmak istedgim islemi js.executeScript methodu ile yap.

        //scrollIntoView(true);methodu belirli bir elemente scrool yapmak icin kullanılabilir.
        //arguments[0] ilk parameteredeki element
        js.executeScript("arguments[0].scrollIntoView(true)", weOffer);
        waitFor(3);
        takeScreenShotOfPage();


        //    Ayni sayfada Enroll Free Courses elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJs(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        //    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJs(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();

        //    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJs(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        //EN USTE GİT
        scrollTabJS();
        waitFor(2);

        //EN ALTA GİT
        scrollEndJS();
        waitFor(2);

    }
}
