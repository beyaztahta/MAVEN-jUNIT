package day12_files_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class FluentWait_02 extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et

//     1. Fluent Wait icin bir obje olustur
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  //MAX BEKLEME SURESI
                .pollingEvery(Duration.ofSeconds(3))  //DENEME ARALIKLARI
                .withMessage("IGNORE EXCEPTİON")     //MESAJ YAZDIRABILIRIM...
                .ignoring(NoSuchMethodException.class);  //TRY CATCH GIBI EXCEPTIONI YAKALA,EXCEPTIONI HANDLE ET DEMEKTIR.

//     2. wait objesini kullanarak bekleme problemini coz.
        WebElement helloWordText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloText= helloWordText.getText();
        Assert.assertEquals("Hello World!",helloText);


    }
}
