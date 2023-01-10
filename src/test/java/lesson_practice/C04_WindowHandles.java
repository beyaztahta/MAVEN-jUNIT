package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C04_WindowHandles extends TestBase {
    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");

        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        String windowHandle1= driver.getWindowHandle();

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        String windowHandle2=driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(windowHandle1);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String java=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertFalse(java.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(windowHandle2);

        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());

    }
}
