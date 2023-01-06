package day10_actionclass_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClass01 extends TestBase {
    @Test
    public void test01() {
//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu ");

//        1.Adım: ACTIONS OBJESI OLUSTURULUR.
        Actions actions = new Actions(driver);

//        2. Adım: UZERINDE CALISMAK ISTEDİGİMİZ ELEMENTİ LOCATE EDELİM.
        WebElement element = driver.findElement(By.xpath("//*[@id='hot-spot']"));

//        3.Adim : perform() kullanarak bu webelement üzerinde action gerçekleştirilir.
//        Method: contextClick

//        Kutuya sag tıklayın
//        TUM ACTIONSLAR actions OBJESIYLE BASLAR perform() ILE BITER.
        actions.contextClick(element).perform();

//        Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
//        Object olusturmak wait gerektiren durumlarda makuldur.

        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

//        Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();


    }
}
