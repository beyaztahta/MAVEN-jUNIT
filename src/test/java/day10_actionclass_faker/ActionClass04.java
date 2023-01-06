package day10_actionclass_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClass04 extends TestBase {
    @Test
    public void test01() {
        //Method: dragAndDropTest
        //En fazla suruklemek icin bu method kullanılır.
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //Kaynak ve Hedef iframe icinde onun icine girmemiz gerekiyor.
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        actions.dragAndDrop(kaynak, hedef).perform();
        //dragAndDrop() surukleme islemini gerceklestirir.

    }

    @Test
    public void test02() {
        //clickAndHold() methodu:

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //Kaynak ve Hedef iframe icinde onun icine girmemiz gerekiyor.
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        actions.
                clickAndHold(kaynak).//kaynagı tut
                moveToElement(hedef).//hedefe koy
                release().//kaynagı bırak
                build().//önceki methodların iliskisini guclendir.
                perform(); //islemi gerceklestir.
    }

    @Test
    public void test03() {
        //moveByOffSetTest() methodu:

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //Kaynak ve Hedef iframe icinde onun icine girmemiz gerekiyor.
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));

        actions.
                clickAndHold(kaynak).
                moveByOffset(430,30).
                release().//kaynagı bırak
                build().
                perform();

    }
}
