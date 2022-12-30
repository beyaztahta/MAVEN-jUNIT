package day07_tb_alert_ifrm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Ifream extends TestBase {

    @Test
    public void test01() {
        //IFrame nedir?
        //User Story:
        //IFRAME:
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");


        //Ana sayfadaki "An iframe with a thin black border:" metnin black border yazisinin oldugunu test edelim
        String actualResult = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        String expectedResult = "black border";
        Assert.assertTrue(actualResult.contains(expectedResult));

        /*
        tag[.='text']  ;Bana bu tag lı metni ver.
        tag[text()='metin'] ;
          */

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //‘Applications lists’ iframe in icinde .Iframe switch to yapmam lazım.

        driver.switchTo().frame(0);//index 0 dan baslar ve ilk iframe e switch yapıyoruz.
        String icMetin=driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedResult1="Applications lists";
        Assert.assertEquals(expectedResult1,icMetin);
       // Assert.assertTrue(icMetin.contains(expectedResult1));


        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

// Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
//Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();//Once Iframe den cıktık.

        String text=driver.findElement(By.xpath("//footer[@class='blog-footer']//p[1]")).getText();
        System.out.println(text);
        String expectedResult2="Povered By";
        Assert.assertTrue(text.contains(expectedResult2));

    }
    /*
   1. Bir sayfadaki toplam iframe sayisini nasıl buluruz?

   Iframe tagı kullanılarak olusturulur.Bu durumda by frame lacator ı kullanılrak tum iframeleri bulurum.

   ***driver.findElements(By.tagName("iframe")
   ***driver.findElements(By.xpath("//iframe")
   List<WebElement> list=driver.findElements(By.tagName("iframe"));
   System.out.println(list.size());

   2. Tekrardan anasayfaya nasıl donersin?
   Iki farkli yol vardir. defaultContenct ya da parentFrame methodlarını kullanarak gecis yapabiliriz.

   3.defaultContenct ve parentFrame arasındaki farklar nelerdir?
  Oncelikle her ikiside frame dısına cıkmamızı saglar. farkları ise:
   -defaultContenct ; ana sayfaya direkt atlatır.
   -parentFrame  ;bir ust seviyeye atlatır.

   4. Bir testCase in fail alma sebepleri neler olabilir?
   -Locatoar ın yanlıs alınması(cozum :tekrar locate alınmalıdır.Degisken element var ise ona gore dinamik bir xpath yazılır.)
   -Wait/Synchronization/Bekleme Problemi (cozum : Implicit wait de yeterli sure oldugundan emin olunmalıdır.30 saniye verilmelidir.
                                            Explicit wait kullanılabilir.)

   -New window(Yeni pencere):switch to window
   -IFRAME  : switch to frame
   -ALERT   :switch to alert

     */
}
