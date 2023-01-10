package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Questions_19_ActionClass extends TestBase {
    @Test
    public void test01() {
//        http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//        Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        hoverOverOnElementActions(driver.findElement(By.xpath("//div[@id='div2']")));
        waitFor(2);

//        Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        doubleClick((driver.findElement(By.xpath("//button[@name='dblClick']"))));
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);
        String expected = "Double Clicked !!";
        Assert.assertEquals(expected, alertText);

//        Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

//        Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        dragAndDropActions(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//div[@id='droppable']")));
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//p[text()='Dropped!']")).getText());
    }
}
