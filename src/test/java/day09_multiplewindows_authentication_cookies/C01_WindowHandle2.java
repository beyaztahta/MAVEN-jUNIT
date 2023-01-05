package day09_multiplewindows_authentication_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String windowHandle1 = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText1 = driver.findElement(By.xpath("//h3")).getText();
        String expectedText1 = "Opening a new window";
        Assert.assertEquals(expectedText1, actualText1);


        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "The Internet";
        Assert.assertEquals(expectedTitle1, actualTitle1);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);

        //---->Buradan sobra ikinci pencere acılır.Second windows da islem yapacagımız icin o pencereye switch to yapmalıyız.
        switchToWindow(1);
        String windowHandle2= driver.getWindowHandle();


        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "New Window";
        Assert.assertEquals(expectedTitle2, actualTitle2);

        switchToWindow(0);


    }
}
