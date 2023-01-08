package day10_actionclass_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClass05 extends TestBase {

    @Test
    public void test01() {

        //Create a method keyboardActions
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)

        WebElement searchBox=driver.findElement(By.name("q"));
        //searchBox.sendKeys("iPhone X fiyatlari"+ Keys.ENTER);//biz ne gonderirsek onu yazdırır ve entera basar. ama bizden istenen shift ile yazmamız.
        // bu sebepten actions sınıfını kullanmamız gerekiyor.

        Actions actions=new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT).//arama kutusunda iken shift tusuna bas.
                sendKeys("iphone x fiyatlari"). //shifte basılı iken yazıyı yaz.
                keyUp(searchBox, Keys.SHIFT).//shifte basmayı bırak
                sendKeys("  cok pahali!"+Keys.ENTER). //normal halde yaz ve enter tusuna bas.
                build().//birden fazla actions methodu kullanıldıgında build() fonksiyonunu kullanmak guzel olur(yapıyı guclendirilir,bu sebepten onerilir.),zorunlu degildir.
                perform();

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas
    }
    /*
        1- Actions nedir?(Actions Class nedir ?)
    Seleniumdan gelen bir kutuphanedir.Mouse ve keyboard islemlerini vgerceklestirmek icin kullandıgımız hazır bir kutuphanedir.
    Ornegin,saga tıklamak(contextclick),cift tıklamak(doubleclick),bir elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerceklestiririz.
    Aynı zamanda shift,control,delete,enter gibi keyboard tuslarınada actions yardımıyla basabiliriz.Bu tur islemlerde sendKeys methodu kullanılır.

        2- Ne tur methodlar kullandin?
    Genelde actions methodları onemlidir.Ve tekrar tekrar kullanmam gerektiginden actions methodlarını iceren bir Resuable methodlar olusturdum ve gerektiginde
    bu resuable methodları kullanıyorum.Ornegin rightClick methodunu bir elemente saga tıklamak icin cagırabilirim.

        3- Hangi methodlari kullandin ne ne ise yarar?
        Mouse ve keyboard islemleriniv gerceklestirmek icin kullandıgımız hazır bir kutuphanedir.
    Ornegin,saga tıklamak(contextclick),cift tıklamak(doubleclick),bir elementin uzerine gitmek(moveToElement) gibi mouse islemlerini gerceklestiririz.
    Aynı zamanda shift,control,delete,enter gibi keyboard tuslarınada actions yardımıyla basabiliriz.Bu tur islemlerde sendKeys methodu kullanılır.

     */
}
