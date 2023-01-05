package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Questions_16_WindowHandle extends TestBase {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String windowHandle1 = driver.getWindowHandle();

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.cssSelector("iframe[id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement actualWrite = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
        Assert.assertTrue(actualWrite.isDisplayed());

        // Elemental Selenium linkine tıklayın
        actualWrite.click();

        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        System.out.println(allWindows);
        driver.switchTo().window(allWindows.get(1));


        // Açılan sayfada sayfa başlığını yazdırınız

        String title = driver.getTitle();
        System.out.println("Elemental Selenium baslıgı "+ " " +title);


        /*
        Set<String>allWindows=driver.getWindowHandles();
        for (String windowHandle : allWindows){
            if(!windowHandle.equals(windowHandle1)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }

         */

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement actualWrite1 = driver.findElement(By.xpath("//a[@class='link']"));
        Assert.assertTrue(actualWrite1.isDisplayed());

        // Source labs linkine tıklayın
        actualWrite1.click();
        List<String>allWindows2=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindows2.get(2));

        // Açılan sayfada sayfa başlığını yazdırınız
        String title1 = driver.getTitle();
        System.out.println("Source labs basligi " +"  "+title1);

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(allWindows.get(0));
        String url=driver.getCurrentUrl();
        System.out.println("İlk sayfanin url si "+"  "+ url);

        // ilk sekmeyi kapatalım
        driver.close();

        driver.switchTo().window(allWindows2.get(2));
        System.out.println(driver.getCurrentUrl());
    }
}
/*
public static void switchWindowListMethod(int windowNumber){
    try{
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(windowNumber-1));
}catch (IndexOutOfBoundsException e){
        System.out.println("Bu pencere bulunamadı");
    }
}
 */
