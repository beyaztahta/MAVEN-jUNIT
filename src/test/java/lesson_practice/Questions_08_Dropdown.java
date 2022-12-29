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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Questions_08_Dropdown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //implicitlyWait bu seleniumdan geilr.her locotarun bekleme suresini ayarlıyoruz o sebepten seleniumdan gelir.
        //Threadsleep javadan gelir.İkisinin arasındaki fark ise implicitlyWait  her locator da sureyi yeniliyor.Threadsleep belirttigimiz sure
        // kadar zorunlu bekliyor(kodalrımız burada mecburen bekler.).

        // https://the-internet.herokuapp.com/dropdown adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void Test01() throws InterruptedException {
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement option1 = driver.findElement(By.xpath("//*[@ id='dropdown']"));
        Select ddwn = new Select(option1);
        ddwn.selectByIndex(1);

        String selectIndex = ddwn.getFirstSelectedOption().getText();
        System.out.println(selectIndex);
        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        ddwn.selectByValue("2");
        String selectValue = ddwn.getFirstSelectedOption().getText();
        System.out.println(selectValue);
        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        ddwn.selectByVisibleText("Option 1");
        String selectVisibleText = ddwn.getFirstSelectedOption().getText();
        System.out.println(selectVisibleText);


        // Tüm option'ları yazdırın
        List<WebElement> tumOptionlar = ddwn.getOptions();

        int count = 1;
        for (WebElement w : tumOptionlar) {
            System.out.println(count + " . Option " + w.getText());
            count++;
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected = 3;
        int actual = tumOptionlar.size();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
