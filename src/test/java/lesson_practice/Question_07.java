package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Question_07 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com sayfasina gidin
        driver.get(" https://www.google.com/");
    }

    @Test
    public void test01() {
        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));

        //       Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@title='Ara']")).sendKeys("Nutella", Keys.ENTER);

        //       Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucSayisiYazisi.getText());

        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String arr[] = sonucSayisiYazisi.getText().split(" ");
        String result = arr[1];
        System.out.println(result);
        result = result.replaceAll("\\D", "");
        int istenenSayi=10000000;
        Assert.assertTrue(Integer.parseInt(result)>istenenSayi);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
