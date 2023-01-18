package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class C09_DownloadFile extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım


    @Test
    public void downloadFileText() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement support=driver.findElement(By.xpath("//button[normalize-space()='Browsers']"));
        Actions action=new Actions(driver);
        action.moveToElement(support).perform();
        waitFor(2);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        support.click();
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        waitFor(2);

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();

        //Açılan pencerede chromedriver'i indirelim
        List<String>allwindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allwindows.get(1));
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
        waitFor(15);

        //Driver'in indiğini doğrulayalım

        String filePath=System.getProperty("user.home")+"/Downloads/chromedriver_win32.zip";
        boolean indirildiMi= Files.exists(Paths.get(filePath));//dosyanın inip inmedigini kontrol etmek icin yazıyoruz.

        Assert.assertTrue(indirildiMi);
    }
}
