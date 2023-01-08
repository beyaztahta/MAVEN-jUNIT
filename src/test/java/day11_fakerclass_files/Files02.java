package day11_fakerclass_files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Files02 extends TestBase {

    @Test
    public void test01() {
        //Class : FileDownloadTest Method : downloadTestExist
        //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download ");

        //b10 all test cases dosyasını indirelim
        //        b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);

//        Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);


         /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }

}

