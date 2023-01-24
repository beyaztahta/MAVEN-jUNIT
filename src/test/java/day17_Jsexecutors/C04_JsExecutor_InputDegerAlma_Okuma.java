package day17_Jsexecutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JsExecutor_InputDegerAlma_Okuma extends TestBase {
//    1)getValueTest metotu olustur
//	  2)https://www.priceline.com/ a git
//    3)Tarih kısmındaki Yazili metinleri al ve yazdır


    @Test
    public void getValueTest() {
        driver.get("https://www.priceline.com/ ");

        getAttributeValueJS("hotelDates");



    }
    //JavaScriptExecutor ile input elementindeki değerleri almak için aşağıdaki adımları izleyebilirsiniz:
    //Web sayfasındaki input elementini locate etmek için WebDriver kullanabilirsiniz. Örneğin, "id" veya "name" attribute'una göre elementi seçebilirsiniz.
    //JavaScriptExecutor'u kullanarak, input elementinin "value" attribute'unu alabilirsiniz. Örnek olarak aşağıdaki gibi bir kod kullanabilirsiniz:

    //WebElement element = driver.findElement(By.id("inputId")); JavascriptExecutor js = (JavascriptExecutor) driver; String value = (String) js.executeScript("return arguments[0].value", element);
    //executeScript metodu ile input elementinin value attribute'unu almış oldunuz.
    //Not: Bu kod örneği sadece id attribute'una göre elementi seçer. Eğer elementi başka bir yolla seçmek isterseniz, locate etme kodunu değiştirmeniz gerekebilir.

}
