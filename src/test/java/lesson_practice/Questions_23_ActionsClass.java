package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Questions_23_ActionsClass extends TestBase {
    @Test
    public void test01() {
        // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement element = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions action = new Actions(driver);

        action.moveToElement(element).clickAndHold(element).moveByOffset(0, 300).
                moveByOffset(0, -100).
                moveByOffset(300, 0).
                moveByOffset(0, 100).
                moveByOffset(-350, 0).
                release(element).
                build().
                perform();
        waitFor(2);


        //    - Son olarak sayfayı temizleyiniz
        driver.findElement(By.xpath("//*[@class='button clear']")).click();

    }

    //    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
    //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
}
