package day08_newwindow;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WidowHandle1 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //ILK SAYFANIN ID SNINI ALALIM:
        String windowHandle1 = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualResult = driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText();
        String expectedResult = "Opening a new window";
        Assert.assertEquals(expectedResult, actualResult);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        //Bu noktada iki pencere actık ve ikincisine gecis yapmak istiyorum .
        // Bunun icin driver.getWindowHandles()ile tum pencerelerin idlerini alalım.
        Set<String> allWindowHandles = driver.getWindowHandles();//{windowHandle1, windowHandle2}
        System.out.println(allWindowHandles);
        for (String handle : allWindowHandles) {
            //eger listedeki id window1 esit degilse bir sonrakine esittir.
            if (!handle.equals(windowHandle1)) {
                driver.switchTo().window(handle);//buradaki handle window2 ye (id sine)  esittir.
                break;
            }
        }
        //BU NOKTADA DRIVER IKINCI PENCEREDE

        String newActualTitle = driver.getTitle();
        String newExpectedTitle = "New Window";
        Assert.assertEquals(newExpectedTitle, newActualTitle);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        String window2Text = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        String expectedWindow2 = "New Window";
        Assert.assertEquals(expectedWindow2, window2Text);

        String windowHandle2 = driver.getWindowHandle();

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(3000);
        driver.switchTo().window(windowHandle1);
        String newTitle = driver.getTitle();
        Assert.assertEquals("The Internet", newTitle);

    }
}
