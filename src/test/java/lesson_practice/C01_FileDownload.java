package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileDownload extends TestBase {
    @Test
    public void test01() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.linkText("some-file.txt")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)

        String farkliKisim=System.getProperty("user.home");//burası herkesin bilgisayarında farklı olan kısımdır.
        String ortakKisim="\\Downloads\\some-file.txt";
        String filePath=farkliKisim+ortakKisim;


        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
