package day07_tb_alert_ifrm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_AlertAccepst extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //  1. butona tıklayın,uyarıdaki OK butonuna tıklayın ve result mesajının

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);

        driver.switchTo()//degisrtir
                .alert()  //alerte degistir.
                .accept();//Bu islemi yaptıgımız zaman okey secenegine tıklanır.
        Thread.sleep(5000);

        // “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResult);
    }

     /*
    *Alertleri nasil automate edersin? How to handle alerts in selenium?
    -Alertler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */
}
