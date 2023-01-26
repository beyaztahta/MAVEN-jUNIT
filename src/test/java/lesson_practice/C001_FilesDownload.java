package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C001_FilesDownload extends TestBase {

    @Test
    public void test01() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. LambdaTest.txt dosyasini indirelim
        WebElement link = driver.findElement(By.xpath("//a[text()='LambdaTest.txt']"));
        link.click();
        waitFor(2);

        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\LambdaTest.txt";

        String path=ortakKisim+farkliKisim;
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}