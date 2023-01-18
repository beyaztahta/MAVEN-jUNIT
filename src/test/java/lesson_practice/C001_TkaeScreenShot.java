package lesson_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.IOException;

public class C001_TkaeScreenShot extends TestBase {
    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    @Test
    public void screenSchotTest() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın resmini alalım
        takeScreenShotOfPage();
        waitFor(3);


        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB).get("https://techproeducation.com");
        takeScreenShotOfPage();
        waitFor(3);

        /*
       FILEUTILS CLASS'I, FILE OBJECT'LERI ILE BIRLIKTE KULLANABILECEGIMIZ METHOD'LAR ICERIR.
       BU METHOD'LARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
 */

        //Tekrar amazon sayfasına dönüp iphone aratalım
        waitFor(3);
        driver.navigate().back();
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone"+ Keys.ENTER);


        //Arama sonucunun resmini alalım
        WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        takeScreenshotOfElement(aramaSonucu);

    }
}
