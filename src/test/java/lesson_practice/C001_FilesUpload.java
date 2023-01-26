package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C001_FilesUpload extends TestBase {
    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\image.png";
        String path=farkliKisim+ortakKisim;

        dosyaSecButonu.sendKeys(path);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
