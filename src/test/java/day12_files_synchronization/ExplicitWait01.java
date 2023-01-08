package day12_files_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitWait01 extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();


        //Hello World! Yazının sitede oldugunu test et
//        WebElement helloWordElement=driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloWordElement.getText());

        //test burada kaldı.Simdi EXPLİCİT WAİT İLE COZUM:

        //1. WebDriverWait objesi olustur.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //2.wait objesini kullanarak bekleme problemini cozmeye calis.
        WebElement helloWordElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String text=helloWordElement.getText();
        Assert.assertEquals("Hello World!",text);

    }

}

