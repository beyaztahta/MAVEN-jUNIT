package day07_tb_alert_ifrm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //3. butona tıklayın,,ve
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(5000);

        // uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Elif CALIK");
        Thread.sleep(5000);


        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        // result mesajında isminizin görüntülendiğini doğrulayın.
        String expectedResult= "Elif CALIK";
        String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();//You entered:Elif CALIK
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
