package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_UploadFile extends TestBase {

    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin


    @Test
    public void test01() {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
               // "C:\Users\hp\Desktop\image.png"--->bunu bilgisayardaki dasya yolumu kopyaladım.

//        String farkliAlan=System.getProperty("user.home");//---->    \Users\hp
//        String ortaakAlan="\\Desktop\\image.png"  ;           //---->     \Desktop\image.png
//        String path=farkliAlan+ortaakAlan;

        String path="C:\\Users\\hp\\Desktop\\image.png";

       WebElement element= driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
       element.sendKeys(path);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//*[@id='terms']")).click();

        // Submit File buttonuna basınız
          driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();


    }
}
