package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Questions_13_Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement>iframeSayisi=driver.findElements(By.xpath("//iframe"));
        System.out.println(iframeSayisi.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement frame = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("//*[@name='a077aa5e']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }

}
