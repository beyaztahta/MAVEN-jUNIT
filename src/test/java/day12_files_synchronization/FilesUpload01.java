package day12_files_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FilesUpload01 extends TestBase {
    @Test
    public void test01() {
//    https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

//    chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.xpath("//*[@id='file-upload']"));

//    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        chooseFileButton.sendKeys(dosyaYolu);
        waitFor(5);

/*
NOTE===>> choose file butonuna yuklemek istedigimiz dosyanın pathi ni gondererek dosyayı sectim.
 */
//    Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//    “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertEquals("File Uploaded!", driver.findElement(By.xpath("//h3")).getText());

    }
}