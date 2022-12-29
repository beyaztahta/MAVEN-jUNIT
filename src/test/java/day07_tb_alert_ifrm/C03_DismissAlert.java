package day07_tb_alert_ifrm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().dismiss();//CANCEL butonuna tıkladık.
        Thread.sleep(3000);

        // ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String expectedResult = "You clicked: Cancel";//istenen yani beklenen deger
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();//gercek deger
        Assert.assertEquals(expectedResult, actualResult);
    }

}
