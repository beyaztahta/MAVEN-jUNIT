package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Questions_09_CheckBox_RadioButon {
    //RadioButon larda daire seklindedir ve sadece bir secim yapabiliriz.
    //CheckBox ise kare seklindedir ve birden fazla secim yapabiliriz.
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void Test01() throws InterruptedException {
        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='vfb-6-0']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='vfb-6-1']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id='vfb-6-2']"));


        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkBox1.isSelected() && !checkBox3.isSelected()) {
            checkBox1.click();
            Thread.sleep(3000);
            checkBox3.click();
            Thread.sleep(3000);
        }//ayrı ayrı if icinde de yapabiliriz.

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());


        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());
    }

}
