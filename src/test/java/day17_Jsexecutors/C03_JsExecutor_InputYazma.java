package day17_Jsexecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JsExecutor_InputYazma extends TestBase {
    //  1)typeTest metotu olustur
    //	2)Techpro education ana sayfasina git
    //	3)Arama kutusuna QA yaz


    @Test
    public void typeTest() {
        driver.get("https://techproeducation.com");
        waitFor(3);
        typeWithJS(driver.findElement(By.xpath("//*[@type='search']")), "QA");
    }
           /*
             INTERVIEW QUESTIONS
        1-Javascript Executor nedir?
        Seleniumdan gelen ve javascript kodlarını calistirmaya yarayan bir interface dir.
        Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir.

        2-Ne zaman ve nasıl kullandın?
        Normal selenium metotları yeterli olmadıgı durumlarda kullanilabilir.
        Ornegin, bazı buttonlara tıklamada problem olabiliyor, yada belirli bir web elementin gorunur olacağı sekilde sayfanın kaydırma islemi,
         yada input kutularindaki değerleri almak icin kullanilabilir.

        3-Sayfayi asagi veya yukarı kaydırma islemi seleniumda nasıl yapılır?
        Seleniumdaki Actions yada javascript executor metotları ile kaydırma islemleri yapılabilir.
        Ornegin, actionslarda page_up, page_down, arrow_up, arrow_down metotlari ile yada js executordaki scrollintoview(true) ile yapılabilir.
        Ben olusturdugumuz reusable metotlarını kullanarak bu islemlile kolaylıkla yapabiliyorum

        4-Bir kutucukdaki(input) elemanın metni nasıl alınabilir?
       Javascript executor ile alabiliriz. Cunki js executor ile attribute degerlerini alma imkanımız var. getText() METORU BU DURUMLARDA CALISMAZ.

        5-Selenium da click yaparken problem yasadigin oldumu?
       Bazen yanlis locator, yada bekleme(wait) problemi gibi durumlarda problem yaşadım. Bazen gizli(hidden) elementlere tiklarkende problem yaşadım. Bu durumlarda javascript executor kullandım ve problemi cozdum.

       6-Selenium otomasyonunda ne tur problemler yaşadın?
     TEKNIK PROBLEMLER :Yanlis locator,bekleme(wait), alert, iframe, pop-up seklindeki reklam bildirimleri,multiple window, hidden elementlere tiklama, …
     TAKIMLA ILGILI PROBLEMLER: (Çok gundeme getirilmemeli). Developer bazen bulduğum bunları kabul etmiyordu. Cozum: takımla beraber değerlendirip fikir birliğine variyorduk.

          */

}