package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandles extends TestBase {

    @Test
    public void test01() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("oppo"+ Keys.ENTER);
        String windowHanle= driver.getWindowHandle();

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();
        List<String> allWindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindows.get(1));

        // Basligin 'Oppo' icerdigini test edin.
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(allWindows.get(0));
        String title2=driver.getTitle();
        System.out.println("title2 = " + title2);

    }
}
