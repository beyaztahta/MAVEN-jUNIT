package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //abstract yapmamızın sebebi: bu sınıfın objesini olusturmak istemiyoruz.Yani TestBase testbase=new TestBase(); yapılamaz.Amacım bu
    //bu sınıfı extends etmek ve hazır methodlarını kullanmaktır.
    protected static WebDriver driver;//driver objesini olusturduk.Burada public veya protected kullanılır,sebebi ise diger child classlardan cagırılmasıdır.Cunku inheritanse olacak.

    //setUp
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //teardown
    @After
    public void tearDown() {
        driver.quit();
    }


}