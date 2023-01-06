package day10_actionclass_faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClass02 extends TestBase {

    /*
      MANUAL:
      Amazon sayfasına git.
      Account & List e uzerinde bekle.-mouse over -hover over
      Acılan pencerede Account linkine tıkla.
      Acılan sayfanın title nın Your Account oldugunu dogrula.
       */

    @Test
    public void test01() {

        //Method : hoverOver() and test the following scenario:
        // Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//        1.Adım: ACTIONS OBJESI OLUSTURULUR.
        Actions actions = new Actions(driver);

//        2. Adım: UZERINDE CALISMAK ISTEDİGİMİZ ELEMENTİ LOCATE EDELİM.
        WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));

//        3.Adım: UYGUN ACTIONS METHODUNU KULLAN.EN SON PERFORM KULLANMAYI UNUTMA.
        actions.moveToElement(element).perform();
        //Sag ust bolumde bulunan “Account & Lists” menüsüne git  moveToElement method

        //“Account” secenegine tikka
       driver.findElement(By.xpath("//*[text()='Account']")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
