package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Questions_21_ActionsClass extends TestBase {
    @Test
    public void test01() {
        //     -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

        //    -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        Actions actions = new Actions(driver);
        WebElement aboutUs = driver.findElement(By.xpath("//div[normalize-space()='About Us']"));

        waitFor(2);
        actions.moveToElement(aboutUs).perform();
        waitFor(2);

        driver.findElement(By.xpath("//*[text()='Fleet']")).click();
        waitFor(3);

        //    -Sayfa başlığının Fleet içerdiğini test edelim
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));

        Assert.assertTrue(driver.getTitle().contains("Fleet"));


    }
}
