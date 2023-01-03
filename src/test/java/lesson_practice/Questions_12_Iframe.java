package lesson_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions_12_Iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ ");

        // ikinci emojiye tıklayın

        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();


        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> list = driver.findElements(By.xpath(" //*[@id='nature']//img"));
        Thread.sleep(3000);

        for (WebElement w : list) {
            w.click();
        }
        //---------->>>>>  list.stream().forEach(WebElement::click);


        // parent iframe e geri donun
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        //---->>>>driver.navigate().refresh();  bu sekilde de yaparak  sayfa yenilendigi icin en basa doner.

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //  apply button a basin
        List<WebElement> list1 = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>liste=new ArrayList<>(Arrays.asList("elif","mavi","mavi","mavi","mavi","mavi","mavi","mavi","mavi","mavi","mavi"));

        for (int i = 0; i < list1.size() ; i++) {
            list1.get(i).sendKeys(liste.get(i));
        }

       driver.findElement(By.xpath("//button[@id='send']")).click();

//        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("elif", Keys.TAB,"calik",Keys.TAB,"mavi",
//                Keys.TAB,"mavi",Keys.TAB,"mavi",Keys.TAB,"mavi",Keys.TAB,"mavi",Keys.TAB,"mavi",Keys.TAB,"mavi",Keys.TAB,"mavi",
//                Keys.TAB,"mavi",Keys.ENTER);

    }
}
