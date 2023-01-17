package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Soru_24 extends TestBase {
    @Test
    public void test01() {
        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        WebElement element = driver.findElement(By.xpath("//canvas"));
        Actions action = new Actions(driver);

        action.moveToElement(element).clickAndHold();
        for (int i = 0; i < 10; i++) {
            action.moveByOffset(5, 5);
        }
        for (int i = 0; i < 10; i++) {
            action.moveByOffset(-5, 5);
        }

        action.release().build().perform();

        waitFor(2);

        //    - Son olarak sayfayı temizleyiniz
        driver.findElement(By.xpath("//*[@class='button clear']")).click();

    }

    @Test
    public void test02() {
        //    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-175,0);//Genellikle slider' lar için bu method kullanılır
        actions.dragAndDropBy(maviTus,-80,0);
        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();

        //-Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        Assert.assertTrue(sari.isDisplayed());

    }

}
