package lesson_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Questions_11_Alert extends TestBase {
    @Test
    public void test01() {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console

        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Alert with OK']")).isDisplayed());
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'

        String text = driver.switchTo().alert().getText();
        System.out.println("Alertin icindeki yazı" + " " + text);
        driver.switchTo().alert().accept();

        //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        String text2 = driver.switchTo().alert().getText();
        System.out.println("Alertin icindeki yazı" + " " + text2);
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechProEducation How are you today"
        //    aseertion these message
        String expected="Hello TechProEducation How are you today";
        String actual=driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        Assert.assertEquals(expected, actual);


    }
}
