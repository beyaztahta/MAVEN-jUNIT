package day14_takescreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreensShot1 extends TestBase {

//    Techpro education a git ve Sayfanin goruntusunu al
//    -“QA” aramasi yap
//    Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”

    @Test
    public void fullPageScreenScot() throws IOException {

//    Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");
        waitFor(3);

        //1.EKRAN GORUNTUSUNU getScreenshotAs() methodu ile alip FILE olarak olusturalım.getScreenshotAs() seleniumdan gelir.

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File goruntu = screenshot.getScreenshotAs(OutputType.FILE); //bu bizim dosya uzantımız.Gecici bir variable a asign ettik.Variable tipi file dir.

        //2.ALMIS OLDUGUM EKRAN GORUNTUSUNU BELIRLEDIGIMIZ PATH e KAYDETECEGIZ.

        String currentDate = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String path = System.getProperty("user.dir") + "\\test-output\\EkranGoruntuleri\\" + currentDate + "image.png";
        File hedef = new File(path);

        //3.GORUNTU ILE DOSYAMI BIRLESTIRIP KAYDET.
        FileUtils.copyFile(goruntu, hedef);

        //        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path


//    -“QA” aramasi yap
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA" + Keys.ENTER);

//      Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”

        waitFor(3);
        String text = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertTrue(text.contains("Search Results for: QA"));

//      Resuable method ile ekran goruntusunu alalım.
        takeScreenShotOfPage();
    }

    /*
      Selenium tun ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen ""getScreenshotAs metotu"" ile alinir.
    -getScreenshotAs metotu seleniumdaki ""TakesScreenshot api"" indan gelir
     */
}
