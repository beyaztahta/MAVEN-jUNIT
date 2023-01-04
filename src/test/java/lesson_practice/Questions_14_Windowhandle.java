package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Questions_14_Windowhandle extends TestBase {
    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin. Sayfa’nin window handle degerini String bir degiskene atayin
        driver.get("https://www.amazon.com");
        String windowHandle1 = driver.getWindowHandle();
        System.out.println(windowHandle1);

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);  // ---->>Yeni bir sekme acmıs olduk.
        driver.get("https://techproeducation.com");
        String windowHandle2 =driver.getWindowHandle();

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "TECHPROEDUCATION";
        Assert.assertFalse(actualTitle1.contains(expectedTitle1));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://walmart.com");
        String windowHandle3=driver.getWindowHandle();

        //Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitle2= driver.getTitle();
        String expectedTitle2 = "Walmart";
        Assert.assertTrue(actualTitle2.contains(expectedTitle2));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandle1);
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
