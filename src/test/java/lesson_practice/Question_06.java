package lesson_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Question_06 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //- ebay sayfasina gidiniz
        driver.get("https://ebay.com");

    }

    @Test
    public void Test01() {
        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- genisligini 225 ve uzunlugu 225 olan resimlerin hepsine tiklayalaim
        // - her sayfanin basligini yazdiralim

        for (int i = 0; i <24; i++) {
            List<WebElement> products = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));

            products.get(i).click();

            System.out.println(i + ". title  " + driver.getTitle());

            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
