package day13_seleniumexceptions;

public class C01_SeleniumExceptions {
   //Interview Questions
    //Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
    //What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
    //What is your solution?-Cozum ne?
    //What type of waits do you use?- Hangi resit wait kullanirsin?
    //Which wait do you prefer?- Hangi wait tercih edersin?
    //Why do you prefer that wait?- Neden onu tercih edersin?
    //How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?

    //NoSuchElementException
    /*
    1-Locatırın dogrulugunu kabul et.
    2-Manuel test ile iframe, yeni pencere, alert vs. gibi elementlerin varlıgını kontrol et.
    3-Bekeleme problemi olabilir.ImplicitWait bekleme suresini cozmuyor.Bu durumda ExplicitWait yada Fluent Wait
    kullanırız.
    4-Sakli olan elementler(display-non)
     */

    //TimeOutException
    /*
    Explicit wait kallanıldıgı zaman ve eleman(element) bulunamadıgı zaman alınan exceptiondır.
    1-Explicit wait ve yanlıs locater olabilir.
    2-Explicit wait var ama sure yeterli degil
    3-Explicit wait ve dogru locater ve sure yeterli ama iframe olabilir.
    COZUMU:
    ---Sureyi arttırmak
    ---Locatarı kontrol etmek
    ---Farklı explicit kullanmak:wait visibilityOfElenmentLocated YERINE presenceOfElementLocated.Yada javascript executor daki waiter sayfa gecislerini beklemek icin kullanabilirim
    ---Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz
     */

    //NullPointerException
    /*

   Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
   Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
   Solution:
   Degiskeni instantiate et
     */

    //StaleElementReferenceException
    /*
   Stale Element =  eski,kullanılamaz durumda,kullanım artık elverisli degil.
   NE ZAMAN ORTAYA CIKAR???
   ---Sayfayi refresh yaptıgımız zaman .
   ---Sayfayi back ve forward yaptıgımızda.
   COZUMUMUZ::::
   Elementi tekrar bulmak
    */


    //WebDriverException
    /*
    Driver versiyonları ve browser versiyonları aynı veya yakın olmadıgı zaman alınır.
    Driver(browser) kapattıktan sonra tekrar kullanmak istediginiz durumlarda alınır.
    ---COZUMU:::
    --Freamwork dizaynının guzel kurulmus olması gerekir,ornegin driver sınıfında birden fazla driver.quit() olmamali.

     */

    /*
    1-Seleniumda aldigin 5 exception
    Null pointer, no such element, time out, slale element reference, web driver
    2-Genel olarak exception aldiginda bozum yolun nedir?
    Hata mesajini oku
    Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
    3-Selniumda kullandigin waitler nelerdir>
     Implicit yada explicit yada fluent
    4-Hangi waiti tercih edersin?
    Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.
    5-Neden Explicit wait?
    Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.
    6-Senkronize(bekleme) problemlerini nasıl çözersin
    Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim.
     Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var.
     Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.
     */
    //InvalidSelectorException
    //InvalidElementStateException
    //ElementNotInteractableException
    //ElementClickInterceptedException
    //InvalidArgumentException
    //JavascriptException
    //RemoteDriverServerException

}
